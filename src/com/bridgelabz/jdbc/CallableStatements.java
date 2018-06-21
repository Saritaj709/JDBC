package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CallableStatements {
public static void main(String[] args)
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC?user=root&password=root");
		PreparedStatement pst = con.prepareCall("{call getidCount()}");
		pst.execute();
		System.out.println("success");
        con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
}
