package com.cdac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cdac.model.Student;

public class StudentDao {

	static Connection connection;

	public static Connection getConnection() {

		try {

			// load the class
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create the connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pune", "root", "cdac");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;

	}

	// add student
	public static int SaveStudent(Student student) {
		int status = 0;

		try {

			Connection connection = StudentDao.getConnection();
			PreparedStatement ps = connection.prepareStatement(
					"insert into Students(Student_Name,Student_email,Student_MobileNumber,Student_address) values (?,?,?,?)");
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setInt(3, student.getMobile_Number());
			ps.setString(4, student.getAddress());

			status = ps.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;

	}

	// update student
	public static int updateStudent(Student student) {
		int status = 0;

		try {

			Connection connection = StudentDao.getConnection();
			PreparedStatement ps = connection.prepareStatement(
					"update Students set Student_Name = ?, Student_email = ?, Student_MobileNumber = ?, Student_address = ? where id = ?");
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setInt(3, student.getMobile_Number());
			ps.setString(4, student.getAddress());
			ps.setInt(5, student.getId());

			status = ps.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;

	}

	// delete student
	public static int deleteStudentById(int id) {
		int status = 0;

		try {

			Connection connection = StudentDao.getConnection();

			PreparedStatement ps = connection.prepareStatement("delete from Students where id = ?");

			ps.setInt(1, id);

			status = ps.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;

	}

	// select student
	public static Student getStudentById(int id) {

		Student student = new Student();

		try {

			Connection connection = StudentDao.getConnection();

			PreparedStatement ps = connection.prepareStatement("select * from Students where id = ?");

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setMobile_Number(rs.getInt(4));
				student.setAddress(rs.getString(5));

			}

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return student;

	}

	public static List<Student> getAllStudents() {
		List<Student> student_ist = new ArrayList<Student>();

		try {
			Connection connection = StudentDao.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from Students");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setMobile_Number(rs.getInt(4));
				student.setAddress(rs.getString(5));

				student_ist.add(student);

				connection.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return student_ist;
	}

}
