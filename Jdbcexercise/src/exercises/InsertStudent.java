package exercises;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import data_access.ConnectionParameters;
import data_access.DbUtils;

import java.util.Scanner;
public class InsertStudent {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        System.out.println("=== Add student ===");
        Scanner input = new Scanner(System.in);
        System.out.print("Id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("First name: ");
        String firstname = input.nextLine();
        System.out.print("Last name: ");
        String lastname = input.nextLine();
        System.out.print("Street: ");
        String street = input.nextLine();
        System.out.print("Postcode: ");
        String postcode = input.nextLine();
        System.out.print("Post office: ");
        String postoffice = input.nextLine().toUpperCase();
        try {
            connection = DriverManager.getConnection(ConnectionParameters.connectionString,
             ConnectionParameters.username, ConnectionParameters.password);
            String sqlText = "INSERT INTO Student (id, firstname, lastname, streetaddress, postcode, postoffice) VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlText);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstname);
            preparedStatement.setString(3, lastname);
            preparedStatement.setString(4, street);
            preparedStatement.setString(5, postcode);
            preparedStatement.setString(6, postoffice);

            preparedStatement.executeUpdate();
            System.out.println("Student data added! ");
        } catch (SQLException sqle) {
            if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
                System.out.println("Cannot insert the student. The student id " + id + " is already in use.");
            } else {
                System.out.println("\n[ERROR] Database error. " + sqle.getMessage());
            }
        } finally {
            DbUtils.closeQuietly(preparedStatement, connection);
        }
    }
}
