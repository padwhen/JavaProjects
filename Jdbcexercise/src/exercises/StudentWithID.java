package exercises;

import java.util.Scanner;
import java.util.List;
import data_access.StudentDAO;
import model.Student;

public class StudentWithID {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== Find student by id (DAO version) ===");
        System.out.print("Enter student id: ");
        int idInput = input.nextInt();
        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.getStudentById(idInput);
        System.out.println(student);
    }
}
