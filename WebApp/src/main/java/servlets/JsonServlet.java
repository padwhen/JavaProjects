package servlets;

import java.io.IOException;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import model.Student;
import java.util.List;
import java.util.ArrayList;

@WebServlet("/jsontest")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student1 = new Student(1, "Phat", "Nguyen", "Karstulantie 8", "00550", "Helsinki");
		Student student2 = new Student(2, "Pad", "When", "Opastinsilta 2B", "00520", "Helsinki");
		List<Student> students = new ArrayList<Student>();
		students.add(student1);
		students.add(student2);
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		String json = gson.toJson(students);
		out.print(json);
	}
}
