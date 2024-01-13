package data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import model.Student;

public class StudentDAO {
    public StudentDAO() {
        try {
            Class.forName(ConnectionParameters.jdbcDriver);
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        }
    }
    private Connection openConnection() throws SQLException {
        return DriverManager.getConnection(ConnectionParameters.connectionString, 
        ConnectionParameters.username, ConnectionParameters.password);
    }
    public List<Student> getStudents() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Student> studentList = new ArrayList<Student>();
        try {
            connection = openConnection();
            String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice FROM Student ORDER BY firstname, lastname";
            preparedStatement = connection.prepareStatement(sqlText);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String streetaddress = resultSet.getString("streetaddress");
                String postcode = resultSet.getString("postcode");
                String postoffice = resultSet.getString("postoffice");
                studentList.add(new Student(id, firstname, lastname, streetaddress, postcode, postoffice));
            }
        } catch (SQLException sqle) {
            System.out.println("\n[ERROR] StudentDAO: getStudents() failed. " + sqle.getMessage() + "\n");
            studentList = null;
        } finally {
            DbUtils.closeQuietly(resultSet, preparedStatement, connection);
        }
        return studentList;
    }

    public Student getStudentById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student student = null;
    
        try {
            connection = openConnection();
            String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice FROM Student WHERE id = ?";
            preparedStatement = connection.prepareStatement(sqlText);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
    
            if (resultSet.next()) {
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String streetaddress = resultSet.getString("streetaddress");
                String postcode = resultSet.getString("postcode");
                String postoffice = resultSet.getString("postoffice");
                student = new Student(id, firstname, lastname, streetaddress, postcode, postoffice);
            }
        } catch (SQLException sqle) {
            System.out.println("\n[ERROR] StudentDAO: getStudentById() failed. " + sqle.getMessage() + "\n");
        } finally {
            DbUtils.closeQuietly(resultSet, preparedStatement, connection);
        }
        return student;
    }

    public int insertStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = openConnection();
            if (getStudentById(student.getId()) != null) {
                System.out.println("Student ID already in use. No row inserted");
                return 1;
            }
            String sqlText = "INSERT INTO Student (id, firstname, lastname, streetaddress, postcode, postoffice) VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlText);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getFirstname());
            preparedStatement.setString(3, student.getLastname());
            preparedStatement.setString(4, student.getStreetaddress());
            preparedStatement.setString(5, student.getPostcode());
            preparedStatement.setString(6, student.getPostoffice());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student inserted succesfully");
                return 0;
            } else {
                System.out.println("Insert operation failed. No rows affected.");
                return -1;
            }
        } catch (SQLException sqle) {
            System.out.println("\n[ERROR] StudentDAO: insertStudent() failed " + sqle.getMessage() + "\n");
            return -1;
        } finally {
            DbUtils.closeQuietly(preparedStatement, connection);
        }
    }
        public int deleteStudent(int id) {
        	Connection connection = null;
        	PreparedStatement preparedStatement = null;
        	try {
        		connection = openConnection();
        		if (getStudentById(id) == null) {
        			System.out.println("Student not found for deletion. ID: " + id);
        			return 1;
        		}
        		String sqlText = "DELETE FROM Student WHERE id = ?";
        		preparedStatement = connection.prepareStatement(sqlText);
        		preparedStatement.setInt(1, id);
        		int rowsAffected = preparedStatement.executeUpdate();
        		if (rowsAffected > 0) {
        			System.out.println("Student deleted successfully");
        			return 0;
        		} else {
        			System.out.println("Delete operation failed.");
        			return -1;
        		}
        	} catch (SQLException sqle) {
        		System.out.println(sqle.getMessage());
        		return -1;
        	} finally {
        		DbUtils.closeQuietly(preparedStatement, connection);
        	}
 
    }
    
}