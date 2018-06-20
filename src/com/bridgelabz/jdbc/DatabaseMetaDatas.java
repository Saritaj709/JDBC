package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DatabaseMetaDatas {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC?user=root&password=root");
			DatabaseMetaData dbmd = con.getMetaData();
			System.out.println("Driver Name : " + dbmd.getDriverName());
			System.out.println("Driver Version : " + dbmd.getDriverVersion());
			System.out.println("User Name : " + dbmd.getUserName());
			System.out.println("Database Product Name : " + dbmd.getDatabaseProductName());
			System.out.println("Database Product Version : " + dbmd.getDatabaseProductVersion());
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
