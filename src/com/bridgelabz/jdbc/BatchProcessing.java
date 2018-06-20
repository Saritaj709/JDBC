package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchProcessing {
	public static void main(String args[]) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC?user=root&password=root");
			con.setAutoCommit(false);

			Statement stmt = con.createStatement();
			stmt.addBatch("insert into user values(196,'pratik',11000)");
			stmt.addBatch("insert into user values(197,'sima',121245)");
			stmt.addBatch("insert into user values(190,'abhi',40000)");
			stmt.addBatch("insert into user values(191,'umesh',50000)");
		    stmt.addBatch("insert into user values(192,'suresh',70000)");
		    stmt.addBatch("insert into user values(194,'nawaz',10000)");
			stmt.addBatch("insert into user values(601,'priya',20000)");
		    stmt.addBatch("insert into registration values('ali','haider','ali@gmail.com','245451457545','sima')");
			System.out.println("adding values");
			stmt.executeBatch();// executing the batch

			con.commit();
			con.close();
		} catch (Exception e) {
			System.out.println("values are already present");
			System.out.println(e.getMessage());
		}
	}
}
