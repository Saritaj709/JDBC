package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DNSAccess {
	public static void main(String ar[]){  
		 try{  
		   String database="JDBC.user";//Here database exists in the current directory  
		  
		   String url="jdbc:mysql://localhost:3306/JDBC?user=root&password=root;  DBQ=" + database + ";DriverID=22;READONLY=true";  
		  
		   Class.forName("com.mysql.jdbc.Driver");  
		   Connection c=DriverManager.getConnection(url); 
				  
		   Statement st=c.createStatement();  
		   ResultSet rs=st.executeQuery("select * from user");  
		    
		   while(rs.next()){  
		    System.out.println(rs.getString(1));  
		   }  
		  
		}catch(Exception ee){System.out.println(ee);}  
		  
		}
	}  