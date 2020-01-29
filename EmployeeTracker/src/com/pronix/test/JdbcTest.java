package com.pronix.test;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JdbcTest
 */
@WebServlet("/JdbcTest")
public class JdbcTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JdbcTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws ServletException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		String JdbcURl = "jdbc:mysql://localhost:3306/web_employee_tracker";
		String User = "Employee";
		String Pass = "Rathna@299299";
		String driver = "com.mysql.jdbc.Driver";
		try {
			PrintWriter write = response.getWriter();
			write.println("Connecting to database: " + JdbcURl);

			Class.forName(driver);
			Connection con = DriverManager.getConnection(JdbcURl, User, Pass);
			

			write.println("Connection success");

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}
}
