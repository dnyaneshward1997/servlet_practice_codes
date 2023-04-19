package com.cdac.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.dao.StudentDao;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sid = request.getParameter("id");

		int id = Integer.parseInt(sid);

		StudentDao.deleteStudentById(id);

		response.sendRedirect("ViewStudentServlet");
	}
}