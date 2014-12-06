//  Weimin Ouyang, 7301005, ouyang@cs.ucsb.edu
//  LibrarySystem.java
//  ProgAssignment4
//
//  Created by Tyler Weimin Ouyang on 12/4/14.
//  Copyright (c) 2014 Golden: Tyler Weimin Ouyang All rights reserved.
//

package ProgAssignment4;

import java.util.ArrayList;

public class LibrarySystem {
	public static void main (String[] args){
		MagicNumber testMagic = new MagicNumber();
		testMagic.setClassification("QA");
		testMagic.setSubclassification("76");
		testMagic.setCopy("2");
		MagicNumber testMagic2 = new MagicNumber("qa","23","12314","2");
		System.out.println(testMagic.toString());
		System.out.println(testMagic2);
		
		Book booktest = new Book(testMagic2, "Tyler", "UCSB", "how to code", "2011", "cs");
		System.out.println(booktest);
		
		Catalog catalog = new Catalog();
		catalog.addBook(booktest);
		
		Operations operationTest = new UserOperations(catalog);
		operationTest.search("tYl");
		
		ArrayList<Book> booklist = new ArrayList<Book>();
		Users userTest = new Users();
		Users studentTest = new Students("tye", "manza", "1233", 123, 1244, booklist, catalog);
		userTest.addUser(studentTest);
		studentTest.addUser(userTest);
		System.out.println(userTest);
		System.out.println(studentTest);
	}
}
