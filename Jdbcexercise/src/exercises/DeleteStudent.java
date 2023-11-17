package exercises;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import data_access.ConnectionParameters;
import data_access.DbUtils;

public class DeleteStudent {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Scanner input = new Scanner(System.in);

        System.out.println("=== Delete student ===");
        System.out.print("Enter student id: ");
        int id = input.nextInt();
        try {
            connection = DriverManager.getConnection(ConnectionParameters.connectionString,
                    ConnectionParameters.username, ConnectionParameters.password);
            String sqlText = "DELETE FROM Student WHERE id = ?";
            preparedStatement = connection.prepareStatement(sqlText);
            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student deleted!");
            } else {
                System.out.println("Nothing deleted. Unknown student id (" + id + ")");
            }
        } catch (SQLException sqle) {
            System.out.println("\n[ERROR] Database error. " + sqle.getMessage());
        } finally {
            DbUtils.closeQuietly(preparedStatement, connection);
        }
    }
}
