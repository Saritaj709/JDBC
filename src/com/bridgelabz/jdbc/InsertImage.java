package com.bridgelabz.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertImage {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC?user=root&password=root");
			PreparedStatement pst = con.prepareStatement("insert into img values(?,?)");
			pst.setString(1, "sarita");
			FileInputStream file = new FileInputStream("/home/bridgelabz/Downloads/p.jpg");
			pst.setBinaryStream(2, file, file.available());
			int i = pst.executeUpdate();

			System.out.println(i + " records updated");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
