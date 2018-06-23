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
import com.bridgelabz.addressbookfactory.DataService;
import com.bridgelabz.addressbookserializer.JSonAddressBookManager;
import com.bridgelabz.datacontroller.JDBCSerializer;
import com.bridgelabz.model.Person;
import com.bridgelabz.service.AddressBookService;
import com.bridgelabz.utility.Utility;

	public class AddressBookController{
		static List<Person> personList = new ArrayList<>();
		private static DataService data;
		public static void main(String[] args) throws Exception {
			System.out.println("welcome to address book manager");
			System.out.println("enter the type : Json/JDBC");
			String obj=Utility.userNext();
				
			AddressBookService manager=AddressBookFactory.getObject(obj);
			manager.getConnection();
			//AddressBookService manager=new JSonAddressBookManager();
			while(true)
			{
				System.out.println("Enter the operation you want to do:\n" + "1.Create new AddressBook\n " + "2.delete user\n"
						+"3.update user details\n"
						+ "4.see details of user\n"
						+ "5.create mutiple address book\n" 
						+"6.show multiple address book\n" 
						+"7.search address book\n"
						+ "8. Exit\n");
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
					case 5:
						manager.createMultipleAddressBook();
						break;
					case 6:	manager.searchMultipleAddressBook();
					break;
					case 7:
						manager.displayMultipleAddressBook();
					break;
				 default:System.out.println("invalid choice,try again");	
				 break;
				}
			}
		}
	}
				/* public static void multipleAddressBook() throws JsonParseException, JsonMappingException, IOException, ParseException, SQLException
				 {
					 while(true)
					 {
						 System.out.println("enter the choice:\n"
						 		+ "1 create mutiple address book\n"
						 		+ "2 show multiple address book\n"
						 		+ "3 search address book\n"
						 		+ "4 exit\n");
						 System.out.println("enter the choice");
						 int choice=Utility.userInteger();
						 switch(choice)
						 {
				case 5:
					manager.createMultipleAddressBook();
					break;
				case 6:	manager.searchMultipleAddressBook();
				break;
				case 7:
					manager.displayMultipleAddressBook();
				break;
				case 4:System.out.println("Loop terminated,try again");
				break;
					
				}
			}
		}
	}*/