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
		Scanner s = new Scanner(System.in);

		System.out.println("Please chose your users group by typing 1 or 2, or EXIT to exit:"
				+ "\n1 for students and professors"
				+ "\n2 for librarians");
		String status = s.nextLine();
		while (!status.equals("EXIT"))
			switch (status){				

			case "1":{
				CommonUsers cu= new CommonUsers();
				do{
					System.out.println("Please type your ID");
					int ID=0;
					try{
						ID = Integer.parseInt(s.nextLine());	
					}catch (NumberFormatException e){
						System.err.println("Invalid Input! ID MUST BE an integer");
						continue;
					}
					int i=0;
					for (; i<users.size(); i++){							
						if ((users.get(i).getUser(ID)) != null){
							if (users.get(i).getUser(ID).getClass().equals(Students.class)){
								cu = (Students) users.get(i).getUser(ID);
								System.out.println("Please type your PIN");
								int PIN = Integer.parseInt(s.nextLine());
								if (! ((Students)cu).comparePIN(PIN)){
									System.out.println("Invalid credential, input anything to try again;"
											+ "\nor type CANCEL to cancel");
									status = s.nextLine();
									break;
								}
								System.out.println("Successfully logged in!");
								status = "loggedin";
								break;
							}
							else if (users.get(i).getUser(ID).getClass().equals(Professors.class)){
								cu = (Professors) users.get(i).getUser(ID);
								System.out.println("Please type your PIN");
								int PIN = Integer.parseInt(s.nextLine());
								if (! ((Professors)cu).comparePIN(PIN)){
									System.out.println("Invalid credential, input anything to try again;"
											+ "\nor type CANCEL to cancel");
									status = s.nextLine();
									break;
								}
								System.out.println("Successfully logged in!");
								status = "loggedin";
								break;
							}
						}							
					}
					if (status.equals("CANCEL") || status.equals("loggedin"))
						break;
					if (i!=0 && (users.get(--i).getUser(ID)) == null)
						System.out.println("ID does not exit");
				}while(true);
				if (status.equals("CANCEL")){
					System.out.println("Please chose your users group by typing 1 or 2, or EXIT to exit:"
							+ "\n1 for students and professors"
							+ "\n2 for librarians");
					status = s.nextLine();
					break;
				}
				System.out.println("Please input date YYYY/M/D");
				String date = s.nextLine();
				try {
					cat.setDate(date);
				}catch (ParseException e){
					System.err.println("Invalid date!");
					System.err.println("Please chose your users group by typing 1 or 2, or EXIT to exit:"
							+ "\n1 for students and professors"
							+ "\n2 for librarians");
					status = s.nextLine();
					break;
				}
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
						MagicNumber mgn = new MagicNumber(s.nextLine());
						cu.checkOut(mgn);
						break;
					}
					case "3":
						System.out.println("Please input the magic number");
						MagicNumber mgn = new MagicNumber(s.nextLine());
						cu.returnBook(mgn);
						break;

					case "4":
						cu.showInfo();
						break;
					case "LOGOUT":
						option = "LOGOUT";
						break;
					default: 
						System.err.println("Invalid Input!");
					}
				} while (!option.equals("LOGOUT"));
				System.out.println("Please chose your users group by typing 1 or 2, or EXIT to exit:"
						+ "\n1 for students and professors"
						+ "\n2 for librarians");
				status = s.nextLine();
				break;
			}

			case "2":{
				Librarians lib = new Librarians();
				do{
					System.out.println("Please type your ID");
					int ID=0;
					try{
						ID = Integer.parseInt(s.nextLine());	
					}catch (NumberFormatException e){
						System.err.println("Invalid Input! ID MUST BE an integer");
						continue;
					}
					int i=0;
					for (; i<users.size(); i++){							
						if (users.get(i).getUser(ID)!= null
								&&users.get(i).getUser(ID).getClass().equals(Librarians.class)){
							lib = (Librarians) users.get(i).getUser(ID);
							System.out.println("Please type your PIN");
							int PIN = Integer.parseInt(s.nextLine());
							if (! ((Librarians)lib).comparePIN(PIN)){
								System.out.println("Invalid credential, input anything to try again;"
										+ "\nor type CANCEL to cancel");
								status = s.nextLine();
								break;
							}
							System.out.println("Successfully logged in!");
							status = "loggedin";
							break;
						}							
					}
					if (status.equals("CANCEL") || status.equals("loggedin"))
						break;
					if (i!=0 && (users.get(--i).getUser(ID)) == null)
						System.out.println("ID does not exit");
				}while(true);
				if (status.equals("CANCEL")){
					System.out.println("Please chose your users group by typing 1 or 2, or EXIT to exit:"
							+ "\n1 for students and professors"
							+ "\n2 for librarians");
					status = s.nextLine();
					break;
				}
				System.out.println("Please input date YYYY/M/D");
				String date = s.nextLine();
				try {
					cat.setDate(date);
				}catch (ParseException e){
					System.err.println("Invalid date!");
					System.err.println("Please chose your users group by typing 1 or 2, or EXIT to exit:"
							+ "\n1 for students and professors"
							+ "\n2 for librarians");
					status = s.nextLine();
					break;
				}
				String option = "";
				do{
					System.out.println("Please select an operation by inputing a number:"
							+"\n1: Search"
							+"\n2: Check out a book"
							+"\n3: Return a book"
							+ "\nLOGOUT");
					option = s.nextLine();
					switch (option){
					case "1":

						break;

					case "2":{

						break;
					}
					case "3":

						break;

					case "LOGOUT":
						option = "LOGOUT";
						break;
					default: 
						System.err.println("Invalid Input!");
					}
				} while (!option.equals("LOGOUT"));
				System.out.println("Please chose your users group by typing 1 or 2, or EXIT to exit:"
						+ "\n1 for students and professors"
						+ "\n2 for librarians");
				status = s.nextLine();
				break;
			}

			default:
				System.err.println("Invalid Input!"+"\nPlease chose your users group by typing 1 or 2, or EXIT to exit:"
						+ "\n1 for students and professors"
						+ "\n2 for librarians");
				status = s.nextLine();
			}

		System.out.println("Byebye!");
	}
}
