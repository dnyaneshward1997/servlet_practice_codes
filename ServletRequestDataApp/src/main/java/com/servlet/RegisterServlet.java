package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String Languages[] = request.getParameterValues("languages");
		String city[] = request.getParameterValues("city");

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.print("<h2>" + userName + "</h2>");
		out.print("<h2>" + password + "</h2>");
		out.print("<h2>" + gender + "</h2>");
		for (String str : Languages) {
			out.print("<h2>" + str + "</h2>");
		}

		out.print("<h2>" + city + "</h2>");

		out.flush();
		out.close();
	}

}
