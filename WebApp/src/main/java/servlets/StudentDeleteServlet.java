package servlets;

import java.io.IOException;
import model.Student;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import com.google.gson.Gson;
import data_access.StudentDAO;
@WebServlet("/deleteStudent")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		StudentDAO studentDAO = new StudentDAO();
		int errorCode = studentDAO.deleteStudent(id);
		Gson gson = new Gson();
		String json = gson.toJson(errorCode);
		out.print(json);
	}
}
