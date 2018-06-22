package com.bridgelabz.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserUtility {
		static Scanner scanner=new Scanner(System.in);
		public static int userInteger()
		{
			try
			{
				//System.out.println("enter the integer value");
				int value=scanner.nextInt();
				return value;
			}
			catch(Exception e)
			{
				scanner.nextLine();
				System.out.println("invalid input,try again");
		      return userInteger();
			}
		}
		public static Double userDouble() {
			// TODO Auto-generated method stub
			try
			{
				//System.out.println("enter the integer value");
				double value=scanner.nextDouble();
				return value;
			}
			catch(Exception e)
			{
				scanner.nextLine();
				System.out.println("invalid input,try again");
		      return userDouble();
			}
		}
		public static String userString()
		{
				//System.out.println("enter the string");
				String value=scanner.nextLine();
				return value;
		}
		public static String userNext()
		{
			//System.out.println("enter the one word String");
			String value=scanner.next();
			return value;
		}
		public static char userCharacter()
		{
		char[] character=scanner.next().toCharArray();
		try
		{
			if(character.length>1)
				character=scanner.nextLine().toCharArray();
		}
		catch(Exception e)
		{
			System.out.println("inavlid input");
		}
		return character[0];
		}
		public static String dateTimeFormatter()
		{
			DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now=LocalDateTime.now();
			String date = dtf.format(now);
			return date;
		}

	}
