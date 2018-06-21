package com.bridgelabz.serviceimplementation;

import java.sql.SQLException;

import com.bridgelabz.database.DatabaseAccessObject;
import com.bridgelabz.service.Services;
import com.bridgelabz.utility.UserUtility;
import com.brigelabz.model.User;

public class ServicesImplementation implements Services {
	
	@Override
	public void login() throws SQLException {
		DatabaseAccessObject dao=new DatabaseAccessObject();
		// TODO Auto-generated method stub
		System.out.println("Please enter valid details to login your profile");
		dao.verifyUser();
	}

	@Override
	public void register() throws SQLException {
		// TODO Auto-generated method stub
		User user = new User();
		DatabaseAccessObject dao=new DatabaseAccessObject();
		dao.getConnection();
			System.out.println("Welcome to the page as a new user  ");

			System.out.println("enter first name of user : ");
			user.setFirstName(UserUtility.userNext());
			System.out.println("enter last name of user : ");
			user.setLastName(UserUtility.userNext());
			System.out.println("enter mobile no. of user : ");
			user.setMobileNo(UserUtility.userNext());
			System.out.println("enter gender of user : ");
			user.setGender(UserUtility.userNext());
			System.out.println("enter email id of user : ");
			user.setEmail(UserUtility.userNext());	
			if(dao.searchUser(user.getEmail())) {
				return;
			}
	
			System.out.println("enter password of user email : ");
			user.setPassword(UserUtility.userNext());
			System.out.println("registration sucessful");
			dao.registerUser(user);
		}
	}


