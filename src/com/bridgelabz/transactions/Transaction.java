package com.bridgelabz.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Transaction {
	public static void main(String args[]) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC?user=root&password=root");
			con.setAutoCommit(false);

			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into user values(200,'abhi',40000)");
			stmt.executeUpdate("insert into user values(201,'umesh',50000)");
			System.out.println("values added");
			con.commit();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
