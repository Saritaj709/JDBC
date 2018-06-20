package com.bridgelabz.jdbc;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RetrieveFile {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC?user=root&password=root");
			PreparedStatement pst = con.prepareStatement("select * from filetable");
			ResultSet rs = pst.executeQuery();

			rs.next();

			Clob c = rs.getClob(2);
			Reader r = c.getCharacterStream();

			FileWriter writer = new FileWriter("/home/bridgelabz/java.txt");

			int i;
			while ((i = r.read()) != -1)
				writer.write((char) i);
			writer.close();
			con.close();
			System.out.println("done");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
