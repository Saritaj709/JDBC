package com.bridgelabz.addressbookserializer;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelabz.model.Person;
import com.bridgelabz.service.AddressBookService;
import com.bridgelabz.utility.Utility;

public class JDBCAddressBookManager implements AddressBookService {
List<Person> personList=new LinkedList<>();
Connection con=null;
ResultSet rs=null;
Statement stmt=null;
PreparedStatement pst=null;
String personTable;
	@Override
	public void addPerson() throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		getConnection();
		Person person=new Person();
		System.out.println("enter Id of person");
		String id = person.setId(Utility.userNext());
		System.out.println("enter firstName of person");
		 String firstName = person.setFirstName(Utility.userNext());
		System.out.println("enter lastName of person");
		String lastName = person.setLastName(Utility.userNext());
		System.out.println("enter address of person");
		String address = person.setAddress(Utility.userNext());
		System.out.println("enter city of person");
		String city = person.setCity(Utility.userNext());
		System.out.println("enter Zip");
		String zip = person.setZip(Utility.userNext());
		System.out.println("enter phone number of person");
		String phone = person.setPhone(Utility.userNext());
		personList.add(person);
		System.out.println("Do you want to save : y/n");
		String choice=Utility.userNext();
		if(choice.equals("y"))
		{
			saveToJDBC(person);
			System.out.println("saved to jdbc");
		}
	}

	@Override
	public void deletePerson() throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		System.out.println("enter the id of person to delete");
		String id=Utility.userNext();
		String delete="Delete from person where id=?";
		pst=con.prepareStatement(delete);
		pst.setString(1,id);
		pst.executeUpdate();
		System.out.println("person removed from address book");
	}
	@Override
    public void deleteBook(String tableName) throws SQLException
    {
    	getConnection();
    	String deleteQuery="drop table "+tableName+"";
    	stmt=con.createStatement();
    	stmt.executeUpdate(deleteQuery);
    	System.out.println("table deleted");
    }
	@Override
	public void updatePerson() throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		System.out.println("enter the id of person whose details you want to update : ");
		String id=Utility.userNext();
		System.out.println("enter new values for address,city,zip,phone to update");
		String address=Utility.userNext();
		String city=Utility.userNext();
		String zip=Utility.userNext();
		String phone=Utility.userNext();
		getConnection();
		String updateQuery="update person set address='"+address+"',city='"+city+"',zip='"+zip+"',phone='"+phone+"' where id='"+id+"';";	
		stmt=con.createStatement();
		stmt.executeUpdate(updateQuery);
		System.out.println("details updated");
	}

	@Override
	public void seePersonDetails() throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		stmt=con.createStatement();
		System.out.println("enter the table name ");
		String tableName=Utility.userNext();
		String table="select * from "+tableName+"";
		rs=stmt.executeQuery(table);
		while(rs.next())
		{
			System.out.println("id is : "+rs.getString(1));
			System.out.println("firstName is : "+rs.getString(2));
			System.out.println("lastName is : "+rs.getString(3));
			System.out.println("address is : "+rs.getString(4));
			System.out.println("city is : "+rs.getString(5));
			System.out.println("zip is : "+rs.getString(6));
			System.out.println("phone is : "+rs.getString(7));
		}
	}

	@Override
	public void createMultipleAddressBook(String tableName) throws JsonParseException, JsonMappingException, IOException, SQLException {
		// TODO Auto-generated method stub
	   String createTable="create table "+tableName+" ("+"id varchar(20),"+"firstName varchar(20),"+"lastName varchar(20),"+"address varchar(20),"+"city varchar(20),"+"zip varchar(20),"+"phone varchar(20)"+")";
	   getConnection();
	   stmt=con.createStatement();
	   stmt.execute(createTable);
	   System.out.println(createTable);
		addPerson();
	   System.out.println("address book created");
	   while(true)
	   {
	   System.out.println("do you want to insert more values :y/n ");
	   String choice=Utility.userNext();
	   if(choice.equals("y")) {
		   addPerson();
	   }
	   else {
		   break;
	   }
	   }
	}

	@Override
	public File searchMultipleAddressBook(String tableName) throws JsonParseException, JsonMappingException, IOException, SQLException {
		// TODO Auto-generated method stub
		getConnection();
		 DatabaseMetaData dbmd = con.getMetaData();
         String[] types = {"TABLE"};
         ResultSet rs = dbmd.getTables(null, null, "%", types);
         while (rs.next()) {
             System.out.println(rs.getString("TABLE_NAME"));
             if(tableName.equals(rs.getString("TABLE_NAME")))
             {
            	 System.out.println("Table found");
            	  System.out.println("do you want to see the details : y/n");
            	  String choice=Utility.userNext();
            	  if(choice.equals("y"))
            		  seePersonDetails();            	
            	 return null;
             }
		System.out.println("table not present");
	
	}
     	return null;
	}
	@Override
	public void displayMultipleAddressBook()
			throws JsonParseException, JsonMappingException, IOException, SQLException {
		// TODO Auto-generated method stub
		getConnection();
		 try {

	            DatabaseMetaData dbmd = con.getMetaData();
	            String[] types = {"TABLE"};
	            ResultSet rs = dbmd.getTables(null, null, "%", types);
	            while (rs.next()) {
	                System.out.println(rs.getString("TABLE_NAME"));
	            }
	        } 
	            catch (SQLException e) {
	            e.printStackTrace();
	            }
	}
	@Override
	public void getConnection() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("connecting to database");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=root");

				System.out.println("connection established");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
	public void saveToJDBC(Person person) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		getConnection();
		System.out.println("enter the tableName to save values : ");
		String tableName=Utility.userNext();
		String query="insert into "+tableName+" values(?,?,?,?,?,?,?)";
		pst=con.prepareStatement(query);
		pst.setString(1,person.getId());
		pst.setString(2,person.getFirstName());
		pst.setString(3,person.getLastName());
		pst.setString(4,person.getAddress());
		pst.setString(5,person.getCity());
		pst.setString(6,person.getZip());
		pst.setString(7,person.getPhone());
		pst.executeUpdate();
		System.out.println("received data");
	}
}
