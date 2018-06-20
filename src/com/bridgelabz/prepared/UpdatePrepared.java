package com.bridgelabz.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdatePrepared {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC?user=root&password=root");
			PreparedStatement stmt = con.prepareStatement("update user420 set name=? where id =?");

			stmt.setString(1, "pratik");
			stmt.setInt(2, 101);

			int i = stmt.executeUpdate();
			System.out.println(i + "records updated");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
