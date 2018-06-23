package com.bridgelabz.addressbookfactory;

import com.bridgelabz.addressbookserializer.JDBCAddressBookManager;
import com.bridgelabz.addressbookserializer.JSonAddressBookManager;
import com.bridgelabz.service.AddressBookService;

public class AddressBookFactory {

public static AddressBookService getObject(String Object)
{
	if(Object.equalsIgnoreCase("Json"))
	{
		AddressBookService obj=new JSonAddressBookManager();
		return obj;
	}
	else if(Object.equalsIgnoreCase("JDBC"))
	{
		AddressBookService obj=new JDBCAddressBookManager();
		return obj;
	}
	else
	{
		System.out.println("sorry,object not matched,pls try again");
	}
	return null;
}
}
