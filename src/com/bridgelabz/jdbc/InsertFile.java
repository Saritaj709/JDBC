package com.bridgelabz.jdbc;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertFile {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC?user=root&password=root");
			PreparedStatement pst = con.prepareStatement("insert into filetable values(?,?)");
			File file = new File("/home/bridgelabz/java.txt");
			FileReader reader = new FileReader(file);
			pst.setInt(1, 101);
			pst.setCharacterStream(2, reader, (int) file.length());

			int i = pst.executeUpdate();
			System.out.println(i + " records inserted");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
