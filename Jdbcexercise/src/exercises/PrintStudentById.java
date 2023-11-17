package exercises;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import data_access.ConnectionParameters;
import data_access.DbUtils;

public class PrintStudentById {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Scanner input = new Scanner(System.in);
        System.out.println("=== Find student by id ===");
        System.out.print("Enter student id: ");
        int idInput = input.nextInt();
        try {
            connection = DriverManager.getConnection(ConnectionParameters.connectionString,
             ConnectionParameters.username, ConnectionParameters.password);
            String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice FROM Student WHERE id = ?";
            preparedStatement = connection.prepareStatement(sqlText);
            preparedStatement.setInt(1, idInput);
            resultSet = preparedStatement.executeQuery();
            boolean found = false;
            if (resultSet.next()) {
                found = true;
                System.out.println(idInput + ", " + resultSet.getString("firstname") + " " + resultSet.getString("lastname")
                + ", " + resultSet.getString("streetaddress") + ", " + resultSet.getInt("postcode") + " " + resultSet.getString("postoffice"));
            }
            if (found == false) {
                System.out.println("Unknown student id (" + idInput + ")");
            }
        } catch (SQLException sqle) {
            System.out.println("\n[ERROR] Database error. " + sqle.getMessage());
        } finally {
            DbUtils.closeQuietly(resultSet, preparedStatement, connection);
        }
    }
}
