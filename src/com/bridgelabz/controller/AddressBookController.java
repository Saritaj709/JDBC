	/******************************************************************************
	 *  Compilation:  javac -d bin AddressBookController.java
	 *  Execution:    java -cp bin com.bridgelabz.oops.addressbook.java AddressBook
	 *  Purpose: Displays a address book management system
	 *
	 *  @author  Sarita
	 *  @version 1.0
	 *  @since  23-06-2018
	 *
	 ******************************************************************************/
	package com.bridgelabz.controller;	
	import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
	import java.util.List;

	import org.codehaus.jackson.JsonParseException;
	import org.codehaus.jackson.map.JsonMappingException;
	import org.json.simple.parser.ParseException;

import com.bridgelabz.addressbookfactory.AddressBookFactory;
import com.bridgelabz.model.Person;
import com.bridgelabz.service.AddressBookService;
import com.bridgelabz.utility.Utility;

	public class AddressBookController{
		static List<Person> personList = new ArrayList<>();
		public static void main(String[] args) throws Exception {
			System.out.println("welcome to address book manager");
			System.out.println("enter the type : Json/JDBC");
			String obj=Utility.userNext();
				
			AddressBookService manager=AddressBookFactory.getObject(obj);
			manager.getConnection();
			while(true)
			{
				System.out.println("Enter the operation you want to do:\n" + "1.Create new AddressBook\n" +"2.delete user\n"
						+"3.update user details\n"
						+ "4.see details of user\n"
						+ "5.create mutiple address book\n" 
						+"6.search multiple address book\n" 
						+"7.display multiple address book\n"
						+ "8. delete multipleAddressBook\n"
						+ "9.Exit\n");
				System.out.println("enter choice");
				int choice=Utility.userInteger();
				switch(choice)
				{
				case 1:manager.addPerson();
				break;
				case 2:manager.deletePerson();
					break;
				case 3:manager.updatePerson();
				break;	
				case 4:manager.seePersonDetails();
				break;
					case 5:System.out.println("enter the name of address book to create :");
					 String bookName=Utility.userNext();
						manager.createMultipleAddressBook(bookName);
						break;
					case 6:System.out.println("enter the name of book to search : ");
					String searchBook=Utility.userNext();
						manager.searchMultipleAddressBook(searchBook);
					break;
					case 7:
						manager.displayMultipleAddressBook();
					break;
					case 8:System.out.println("enter the name of address book to remove : ");
					String bookDelete=Utility.userNext();
						manager.deleteBook(bookDelete);
				 default:System.out.println("invalid choice,try again");	
				 break;
				}
			}
		}
	}	