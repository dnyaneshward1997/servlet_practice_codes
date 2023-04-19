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

@WebServlet("/EditStudentServlet2")
public class EditStudentServlet2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String sid = request.getParameter("id");

		int id = Integer.parseInt(sid);

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int Mobile_Number = Integer.parseInt(request.getParameter("Mobile_Number"));
		String address = request.getParameter("address");

		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setEmail(email);
		student.setMobile_Number(Mobile_Number);
		student.setAddress(address);

		int status = StudentDao.updateStudent(student);
		if (status > 0) {
			response.sendRedirect("ViewStudentServlet");
		} else {
			out.println("Sorry! unable to update record");
		}

		out.close();
	}

}