package com.bridgelabz.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.bridgelabz.jdbc.JDBCUtility;

public class InsertPrepared {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC?user=root&password=root");

			PreparedStatement stmt = con.prepareStatement("insert into user420 values(?,?)");
			System.out.println("enter id");
			int id=JDBCUtility.userInteger();
			stmt.setInt(1,id);// 1 specifies the first parameter in the query
			System.out.println("enter name");
			String name=JDBCUtility.userNext();
			stmt.setString(2,name);

			int i = stmt.executeUpdate();
			System.out.println(i + " records inserted");

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
