package com.webtracker.code;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestDBServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Connection variable
		String user = "root";
		String password = "root";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.jdbc.Driver";
		
		//get connection
		try {
				PrintWriter pw = response.getWriter();
				
				pw.println("Connecting to DB");
				
				Class.forName(driver);
				Connection mycon = DriverManager.getConnection(jdbcUrl, user, password);
				
				pw.println("Connection successful");
				
				mycon.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
