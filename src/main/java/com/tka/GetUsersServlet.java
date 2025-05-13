package com.tka;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/get-users")
public class GetUsersServlet extends HttpServlet {
	
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = DBConnection.getConnection();
		try {
			String query = "SELECT * FROM user";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<User> list = new ArrayList<User>();
			while(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				int age = rs.getInt("age");
				String city = rs.getString("city");
				
				User user = new User(username, password, age, city);
				list.add(user);
			}
			
			request.setAttribute("users", list);
			RequestDispatcher rd = request.getRequestDispatcher("users.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
