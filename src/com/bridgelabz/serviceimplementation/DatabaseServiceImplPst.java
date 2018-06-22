package com.bridgelabz.serviceimplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.service.DatabaseService;
import com.bridgelabz.service.UserService;
import com.bridgelabz.utility.UserUtility;
import com.brigelabz.model.User;

public class DatabaseServiceImplPst implements DatabaseService{
		Connection con = null;
	    PreparedStatement pst = null;
		ResultSet rs = null;
		public DatabaseServiceImplPst()
		{
			
		}
		@Override
		public void getConnection() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("connecting to database");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC?user=root&password=root");

				System.out.println("connection established");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		public void registerUser(User user) throws SQLException {
		  getConnection();
			String sql = "insert into register values(?,?,?,?,?,?)";

			pst = con.prepareStatement(sql);
			pst.setString(1, user.getFirstName());
			pst.setString(2, user.getLastName());
			pst.setString(3, user.getMobileNo());
			pst.setString(4, user.getGender());
			pst.setString(5, user.getEmail());
			pst.setString(6, user.getPassword());

			pst.executeUpdate();

			System.out.println("details inserted into table");
		}
		@Override
		public void verifyUser() throws SQLException {
			
			UserService service = new UserServiceImplementation();
	        getConnection();
			System.out.println("enter your email");
			String email = UserUtility.userNext();
			System.out.println("enter your password");
			String pwd = UserUtility.userNext();

			String query = "select fname from register where email=? and password=?";

			pst = con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, pwd);
			rs = pst.executeQuery();
			if (rs.next()) {
				String user = rs.getString(1);
				System.out.println("valid user : " + user);
				System.out.println("login successful");
			} else {
				System.out.println("given details are invalid,pls register to join");
				service.register();
			}
		}
		@Override
		public void closeConnection() throws SQLException {
			con.close();
			System.out.println("Connection disconnected");
		}
		@Override
		public boolean searchUser(String email) throws SQLException {
		
			String query = "select email from register";

			pst = con.prepareStatement(query);

			rs = pst.executeQuery(query);
			while (rs.next()) {
				if (rs.getString(1).equals(email)) {
					System.out.println("The user with the given email already exists");
					return true;
				}	
			}
			return false;
		}
	}
