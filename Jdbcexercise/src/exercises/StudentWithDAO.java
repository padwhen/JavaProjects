package exercises;

import data_access.StudentDAO;

import java.util.List;
import data_access.StudentDAO;
import model.Student;

public class StudentWithDAO {
    public static void main(String[] args) {
        System.out.println("=== Print students (DAO version) ===");
        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentsList = studentDAO.getStudents();
        if (studentsList == null) {
            System.out.println("The database is temporarily unavailable. Please try again later.");
        } else {
            for (Student student : studentsList) {
                System.out.println(student.getId() + ": " + student.getFirstname() + " " + student.getFirstname() + ", " + student.getStreetaddress() + ", " + student.getPostcode() + " " + student.getPostcode());
            }
        }
    }
}
