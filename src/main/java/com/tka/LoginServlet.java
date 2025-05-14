package com.tka;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login-user")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			String query = "SELECT * FROM user WHERE username=? and password=?";
			Connection connection = DBConnection.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("msg", "invalid");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

//		if("admin".equals(username) && "123".equals(password)) {
//			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
//			rd.forward(request, response);
//		}else {
//			
//			request.setAttribute("msg", "invalid");
//			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//			rd.forward(request, response);
//			
//		}

		System.out.println("in get");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response); // forward GET requests to POST logic
	}

}
