package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Resultset {
	
	public static void main(String args[]) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC?user=root&password=root");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("select * from user");

			// getting the record of 3rd row
			rs.absolute(3);
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
