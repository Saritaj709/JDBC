package com.bridgelabz.serviceimplementation;

import java.sql.SQLException;

import com.bridgelabz.controller.Controller;
import com.bridgelabz.service.DatabaseService;
import com.bridgelabz.service.UserService;
import com.bridgelabz.utility.UserUtility;
import com.brigelabz.model.User;

	public class UserServiceImplementation implements UserService {
		DatabaseService dbService;
		public UserServiceImplementation(DatabaseService dbService)
		{
			this.dbService=dbService;
		}
		
		public UserServiceImplementation() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void login() throws SQLException {
			// TODO Auto-generated method stub
			System.out.println("Please enter valid details to login your profile");
			dbService.getConnection();
			dbService.verifyUser();
		}

		@Override
		public void register() throws SQLException {
			// TODO Auto-generated method stub
			User user = new User();
			dbService.getConnection();
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
				if(dbService.searchUser(user.getEmail())) {
					return;
				}
		
				System.out.println("enter password of user email : ");
				user.setPassword(UserUtility.userNext());
				System.out.println("registration sucessful");
				dbService.registerUser(user);
			}
		}