/******************************************************************************
 *  Compilation:  javac -d bin UserLogin.java
 *  Execution:    java -cp bin com.bridgelabz.register.java User
 *  Purpose: To allow user to login and register their details
 *
 *  @author  Sarita
 *  @version 1.0
 *  @since  18-06-2018
 ******************************************************************************/
package com.bridgelabz.controller;

import java.sql.SQLException;

import com.bridgelabz.database.DatabaseAccessObject;
import com.bridgelabz.serviceimplementation.ServicesImplementation;
import com.bridgelabz.utility.UserUtility;

public class UserController {

	public static void main(String[] args) throws SQLException {

		ServicesImplementation services = new ServicesImplementation();
		DatabaseAccessObject dao = new DatabaseAccessObject();
		dao.getConnection();
		System.out.println("WELCOME To USER EMAIL PAGE");
		while (true) {
			System.out.println("enter your choice : 1 to login\n" + "2 to register\n");
			int choice = UserUtility.userInteger();
			switch (choice) {
			case 1:
				services.login();
				break;
			case 2:
				services.register();
				break;
			}
		}
	}
}
