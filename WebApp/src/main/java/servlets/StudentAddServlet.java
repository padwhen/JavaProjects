package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import com.google.gson.Gson;
import data_access.StudentDAO;
import model.Student;
@WebServlet("/addStudent")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String streetaddress = request.getParameter("streetaddress");
		String postcode = request.getParameter("postcode");
		String postoffice = request.getParameter("postoffice");
		
		StudentDAO studentDAO = new StudentDAO();
		Student student = new Student(id, firstname, lastname, streetaddress, postcode, postoffice);
		int errorCode = studentDAO.insertStudent(student);
		Gson gson = new Gson();
		String json = gson.toJson(errorCode);
		out.println(json);
	}

}
