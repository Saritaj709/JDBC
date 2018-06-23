package com.bridgelabz.datacontroller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.bridgelabz.addressbookfactory.DataService;
import com.bridgelabz.model.Person;

public class JDBCSerializer implements DataService {
	Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
	PreparedStatement pst=null;
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
@Override
	public List<Person> read(List<Person> person) throws SQLException {
		// TODO Auto-generated method stub
	getConnection();
	 person=new LinkedList();
	String query="select * from person"	;
	stmt=con.createStatement();
	rs=stmt.executeQuery(query);
	ResultSetMetaData rsmd=rs.getMetaData();
    int NoOfCol=rsmd.getColumnCount();
	while(rs.next())
	{
		for(int index=0;index<NoOfCol;index++)
		System.out.println(rs.getString(index));
	}
	return person;
	}

	@Override
	public void save(List<Person> personList) throws SQLException {
		// TODO Auto-generated method stub
		 personList=new LinkedList();
		//person.add(new Person());	*/
		getConnection();
		String query="insert into person values(?,?,?,?,?,?,?)";
		pst=con.prepareStatement(query);
		Person person=new Person();
		pst.setString(1,person.getId());
		pst.setString(2, person.getFirstName());
		pst.setString(3,person.getLastName());
		pst.setString(4,person.getAddress());
		pst.setString(5,person.getCity());
		pst.setString(6,person.getZip());
		pst.setString(7,person.getPhone());
		personList.add(person);
		pst.executeUpdate();
	}
}
