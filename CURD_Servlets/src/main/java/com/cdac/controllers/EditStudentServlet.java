package com.cdac.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.dao.StudentDao;
import com.cdac.model.Student;

@WebServlet("/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<h1>Update Employee</h1>");

		String sid = request.getParameter("id");

		int id = Integer.parseInt(sid);

		Student student = StudentDao.getStudentById(id);

		out.print("<form action='EditStudentServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='" + student.getId() + "'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + student.getName() + "'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='" + student.getEmail()
				+ "'/></td></tr>");
		out.print("<tr><td>Mobile Number:</td><td><input type='number' name='Mobile_Number' value='"
				+ student.getMobile_Number() + "'/></td></tr>");
		out.print("<tr><td>Address:</td><td><input type='text' name='address' value='" + student.getAddress()
				+ "'/></td></tr>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");

		out.close();
	}
}
