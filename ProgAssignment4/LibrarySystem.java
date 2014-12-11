//  Weimin Ouyang, 7301005, ouyang@cs.ucsb.edu
//  LibrarySystem.java
//  ProgAssignment4
//
//  Created by Tyler Weimin Ouyang on 12/4/14.
//  Copyright (c) 2014 Golden: Tyler Weimin Ouyang All rights reserved.
//

package ProgAssignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;


public class LibrarySystem {
	public static void main (String[] args){

		File data = new File("./Library.data");
		Catalog cat = new Catalog();
		ArrayList<Users> users = new ArrayList<Users>();
		Parser( data, cat, users );
		Scanner s = new Scanner(System.in);

		String status = "";
		String usergroup = "";
		while (!usergroup.equals("EXIT")){			
			System.out.println("Please chose your users group by typing 1 or 2, or EXIT to exit:"
					+ "\n1 for students and professors"
					+ "\n2 for librarians");
			usergroup = s.nextLine();
			status = "";
			
			switch (usergroup){				
			case "1":{
				CommonUsers cu= new CommonUsers();				
				do{
					int ID=0;
					String temp = "";
					System.out.println("Please type your ID"
							+"\nor type CANCEL to cancel");
					try{						
						ID = Integer.parseInt(temp=s.nextLine());	
					}catch (NumberFormatException e){
						if (temp.equals("CANCEL")){
							status = temp;
							break;
						}
						System.out.println("Invalid Input! ID MUST BE an integer");
						continue;
					}
					int i=0;
					for (; i<users.size(); i++){							
						if ((users.get(i).getUser(ID)) != null){
							if (users.get(i).getUser(ID).getClass().equals(Students.class))
								cu = (Students) users.get(i).getUser(ID);

							else if (users.get(i).getUser(ID).getClass().equals(Professors.class))
								cu = (Professors) users.get(i).getUser(ID);

							System.out.println("Please type your PIN"
									+"\nor type CANCEL to cancel");
							i++;
							int PIN = 0;
							try{						
								PIN = Integer.parseInt(temp=s.nextLine());	
							}catch (NumberFormatException e){
								if (temp.equals("CANCEL")){
									status = temp;
									break;
								}
								System.out.println("Invalid Input! PIN MUST BE an integer");
								break;
							}
							if (! cu.comparePIN(PIN)){
								System.out.println("Invalid credential, type TRY to try again;"
										+ "\nor type CANCEL to cancel");
								status = s.nextLine();
								break;
							}
							System.out.println("Successfully logged in!");
							status = "loggedin";
							break;
						}						
					}
					if (i!=0 && (users.get(--i).getUser(ID)) == null)
						System.out.println("ID does not exit");					
				}while(!status.equals("CANCEL") && !status.equals("loggedin"));
				if (status.equals("CANCEL")){
					break;
				}
				do{
					System.out.println("Please input date YYYY/M/D");
					String date = s.nextLine();
					try {
						cat.setDate(date);
					}catch (ParseException e){
						System.out.println("Invalid date!");
						continue;
					}
					break;
				}while (true);
				String option = "";
				do{
					System.out.println("Please select an operation by inputing a number:"
							+"\n1: Search"
							+"\n2: Check out a book"
							+"\n3: Return a book"
							+"\n4: Show all of your information"
							+ "\nLOGOUT");
					option = s.nextLine();
					switch (option){
					case "1":
						System.out.println("Please input a keyword");
						String keyword = s.nextLine();
						cu.search(keyword);
						break;

					case "2":{
						System.out.println("Please input the magic number");
						MagicNumber mgn;
						try{
						mgn = new MagicNumber(s.nextLine());
						}catch (ArrayIndexOutOfBoundsException e){
							break;
						}
						cu.checkOut(mgn);
						break;
					}
					case "3":
						System.out.println("Please input the magic number");
						MagicNumber mgn;
						try{
						mgn = new MagicNumber(s.nextLine());
						}catch (ArrayIndexOutOfBoundsException e){
							break;
						}
						cu.returnBook(mgn);
						break;

					case "4":
						cu.showInfo();
						break;
					case "LOGOUT":
						break;
					default: 
						System.out.println("Invalid Input!");
					}
				} while (!option.equals("LOGOUT"));
				break;
			}

			case "2":{
				Librarians lib = new Librarians();
				do{
					int ID=0;
					String temp = "";
					System.out.println("Please type your ID"
							+"\nor type CANCEL to cancel");
					try{						
						ID = Integer.parseInt(temp=s.nextLine());	
					}catch (NumberFormatException e){
						if (temp.equals("CANCEL")){
							status = temp;
							break;
						}
						System.out.println("Invalid Input! ID MUST BE an integer");
						continue;
					}
					int i=0;
					for (; i<users.size(); i++){							
						if (users.get(i).getUser(ID)!= null
								&& users.get(i).getUser(ID).getClass().equals(Librarians.class)){
							lib = (Librarians) users.get(i).getUser(ID);
							i++;
							System.out.println("Please type your PIN"
									+"\nor type CANCEL to cancel");
							int PIN = 0;
							try{						
								PIN = Integer.parseInt(temp=s.nextLine());	
							}catch (NumberFormatException e){
								if (temp.equals("CANCEL")){
									status = temp;
									break;
								}
								System.out.println("Invalid Input! PIN MUST BE an integer");
								break;
							}
							if (! ((Librarians)lib).comparePIN(PIN)){
								System.out.println("Invalid credential, type TRY to try again;"
										+ "\nor type CANCEL to cancel");
								status = s.nextLine();
								break;
							}
							System.out.println("Successfully logged in!");
							status = "loggedin";
							break;
						}						
					}
					if (i!=0 && (users.get(--i).getUser(ID)) == null)
						System.out.println("ID does not exit");					
				}while(!status.equals("CANCEL") && !status.equals("loggedin"));
				if (status.equals("CANCEL")){
					break;
				}
				do{
					System.out.println("Please input date YYYY/M/D");
					String date = s.nextLine();
					try {
						cat.setDate(date);
					}catch (ParseException e){
						System.out.println("Invalid date!");
						continue;
					}
					break;
				}while (true);
				String option = "";
				do{
					System.out.println("Please select an operation by inputing a number:"
							+"\n1: Operations for a specific user"
							+"\n2: L3: List all users who have at least one overdue item"
							+ "\nLOGOUT");
					option = s.nextLine();
					switch (option){
					case "1":{
						status = "";
						CommonUsers cu = new CommonUsers();
						do{
							System.out.println("Please input the user's ID"
									+ "\nor CANCEL to cancel");
							int ID=0;
							String temp = "";
							try{						
								ID = Integer.parseInt(temp=s.nextLine());	
							}catch (NumberFormatException e){
								if (temp.equals("CANCEL")){
									status = temp;
									break;
								}
								System.out.println("Invalid Input! ID MUST BE an integer");
								continue;
							}
							int i=0;
							for (; i<users.size(); i++){							
								if (users.get(i).getUser(ID)!= null){
									if (users.get(i).getUser(ID).getClass().equals(Students.class))
										cu = (Students) users.get(i).getUser(ID);
									else if (users.get(i).getUser(ID).getClass().equals(Professors.class))
										cu = (Professors) users.get(i).getUser(ID);
									i++;
									status = "loggedin";
									System.out.println("User ID: "+ID);
									break;
								}						
							}
							if (i!=0 && (users.get(--i).getUser(ID)) == null)
								System.out.println("ID does not exit");	
						}while(!status.equals("CANCEL") && !status.equals("loggedin"));
						if (status.equals("CANCEL")){
							break;
						}
						do{
							System.out.println("Please select an operation by inputing a number:"
									+"\n1: Search"
									+"\n2: Check out a book"
									+"\n3: Return a book"
									+"\n4: L1: List this user's information"
									+"\n5: L2: Change this user's status"
									+ "\nRETURN");
							option = s.nextLine();
							switch (option){
							case "1":
								System.out.println("Please input a keyword");
								String keyword = s.nextLine();
								cu.search(keyword);
								break;

							case "2":{
								if (cu.block){
									System.out.println("User is blocked");
									break;
								}
								System.out.println("Please input the magic number");
								MagicNumber mgn;
								try{
								mgn = new MagicNumber(s.nextLine());
								}catch (ArrayIndexOutOfBoundsException e){
									break;
								}
								cu.checkOut(mgn);
								break;
							}
							case "3":
								System.out.println("Please input the magic number");
								MagicNumber mgn;
								try{
								mgn = new MagicNumber(s.nextLine());
								}catch (ArrayIndexOutOfBoundsException e){
									break;
								}
								cu.returnBook(mgn);
								break;

							case "4":
								cu.showInfo();
								break;
							case "5":{
								int blockUser = 0;
								System.out.println("Please select an operation by inputing a number:"
										+"\n1: Block the user"
										+"\n0: Unblock the user");
								try{
									blockUser = Integer.parseInt(s.nextLine());
								}catch (NumberFormatException e){									
									System.out.println("Invalid Input! MUST BE 1 or 0");
									break;
								}
								lib.L2(cu, blockUser);
								break;
							}								
							case "RETURN":
								option = "RETURN";
								break;
							default: 
								System.out.println("Invalid Input!");
							}
						} while (!option.equals("RETURN"));
						break;
					}

					case "2":{
						System.out.println("List of usera who have at least one overdue item:");
						lib.L3(users);
						break;
					}


					case "LOGOUT":
						break;
					default: 
						System.out.println("Invalid Input!");
					}
				} while (!option.equals("LOGOUT"));
				break;
			}
			case "EXIT":
				break;

			default:
				System.out.println("Invalid Input!");
			}

		}
		System.out.println("Byebye!");
		s.close();
	}
	
	private static void  Parser(File data, Catalog cat, ArrayList<Users> users){
		try {
			Scanner s = new Scanner(data);
			System.out.println("Loading data");
			s.nextLine();
			String type = s.nextLine().trim(); 
			// Load books
			if (type.contains("Books")){
				s.nextLine();
				while (s.hasNextLine()){
					String test = s.nextLine();
					if (test.contains(":::::")){
						type = s.nextLine();
						break;
					}
					MagicNumber mn = new MagicNumber(test);
					cat.addBook(new Book(mn, s.nextLine(),
							s.nextLine(),
							s.nextLine(),
							s.nextLine(),
							s.nextLine()));
				}
			}
			// Load students
			if (type.contains("Students")){
				s.nextLine();
				String test = s.nextLine();
				while (s.hasNextLine()){
					if (test.isEmpty())
						break;
					if (test.contains(":::::")){
						type = s.nextLine();
						break;
					}
					Students stu = new Students(Integer.parseInt(test),
							Integer.parseInt(s.nextLine()),
							s.nextLine(),
							s.nextLine(),
							s.nextLine(),
							cat);
					stu.setBooklist(s.nextLine());
					if ((test = s.nextLine()).contains("Blocked")){
						stu.setBlock();
						test = s.nextLine();
					}
					users.add(stu);
				}
			}
			// Load professors
			if (type.contains("Professors")){
				s.nextLine();
				String test = s.nextLine();
				while (s.hasNextLine()){
					if (test.isEmpty())
						break;
					if (test.contains(":::::")){

						type = s.nextLine();
						break;
					}
					Professors pro = new Professors(Integer.parseInt(test),
							Integer.parseInt(s.nextLine()),
							s.nextLine(),
							s.nextLine(),
							s.nextLine(),
							cat);
					pro.setBooklist(s.nextLine());
					if ((test = s.nextLine()).contains("Blocked")){
						pro.setBlock();
						test = s.nextLine();
					}
					users.add(pro);
				}
			}
			// Load librarians
			if (type.contains("Librarians")){
				s.nextLine();
				String test = s.nextLine();
				while (s.hasNextLine() ){	
					if (test.isEmpty())
						break;
					if (test.contains(":::::")){
						type = s.nextLine();
						break;
					}
					Librarians lib = new Librarians(Integer.parseInt(test),
							Integer.parseInt(s.nextLine()),
							s.nextLine(),
							s.nextLine(),
							s.nextLine(),
							cat);
					users.add(lib);
				}
			}
			s.close();	
			System.out.println("Data loaded");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
