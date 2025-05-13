package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/jsp_servlet?createDatabaseIfNotExist=true","root","root");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return connection;

	}
}
