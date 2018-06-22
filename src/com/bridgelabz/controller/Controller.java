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

import com.bridgelabz.service.DatabaseService;
import com.bridgelabz.service.UserService;
import com.bridgelabz.serviceimplementation.DatabaseServiceImplPst;
import com.bridgelabz.serviceimplementation.DatabaseServiceImplStmt;
import com.bridgelabz.serviceimplementation.UserServiceImplementation;
import com.bridgelabz.utility.UserUtility;

public class Controller {

	public static void main(String[] args) throws SQLException {

		System.out.println("enter the type database class you want to use:Stmt/Pst");
		String choic = UserUtility.userNext();
		DatabaseService dbService = getObject(choic);

		dbService.getConnection();
		UserService service = new UserServiceImplementation(dbService);
		System.out.println("WELCOME To USER EMAIL PAGE");
		while (true) {
			System.out.println("enter your choice : 1 to login\n" + "2 to register\n");
			int choice = UserUtility.userInteger();
			switch (choice) {
			case 1:
				service.login();
				break;
			case 2:
				service.register();
				break;
			}
		}
	}

	public static DatabaseService getObject(String str) {
		if (str.equalsIgnoreCase("stmt")) {
			DatabaseService object = new DatabaseServiceImplStmt();
			return object;
		} else if (str.equalsIgnoreCase("Pst")) {
			DatabaseService object1 = new DatabaseServiceImplPst();
			return object1;
		} else {
			System.out.println("not matched");
		}
		return null;
	}
}
