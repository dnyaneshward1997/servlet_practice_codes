package com.cdac.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.dao.StudentDao;
import com.cdac.model.Student;

@WebServlet("/ViewStudentServlet")
public class ViewStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='addStudent.html'>Add New Student</a>");
		out.println("<h1>Students List</h1>");

		List<Student> students_list = StudentDao.getAllStudents();

		out.print("<table border='1' width='100%'");
		out.print(
				"<tr><th>Student Id</th><th>Student Name</th><th>Student Email</th><th>Student Mobile number</th><th>Student Address</th>  <th>Edit</th><th>Delete</th></tr>");
		for (Student student : students_list) {
			out.print("<tr><td>" + student.getId() + "</td><td>" + student.getName() + "</td><td>" + student.getEmail()
					+ "</td>   <td>" + student.getMobile_Number() + "</td><td>" + student.getAddress()
					+ "</td><td><a href='EditServlet?id=" + student.getId()
					+ "'>edit</a></td>  <td><a href='DeleteServlet?id=" + student.getId() + "'>delete</a></td></tr>");
		}
		out.print("</table>");

		out.close();

	}
}