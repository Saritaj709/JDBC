package com.bridgelabz.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeletePrepared {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC?user=root&password=root");
			PreparedStatement pst = con.prepareStatement("Delete from register where email=?");
			pst.setString(1, "prasna@gmail.com");
			int i = pst.executeUpdate();
			System.out.println(i + " records updated");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
