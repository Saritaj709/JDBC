package com.bridgelabz.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.bridgelabz.jdbc.JDBCUtility;

public class DynamicPrepared {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC?user=root&password=root");
			PreparedStatement pst = con.prepareStatement("insert into user420 values(?,?)");
			while (true) {
				System.out.println("enter id : ");
				int id = JDBCUtility.userInteger();
				System.out.println("enter name : ");
				String name = JDBCUtility.userNext();

				pst.setInt(1, id);
				pst.setString(2, name);

				int i = pst.executeUpdate();
				System.out.println(i + " records updated");

				System.out.println("Do you want to continue : y/n");
				String choice = JDBCUtility.userNext();
				if (choice.equals("n")) {
					break;
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
