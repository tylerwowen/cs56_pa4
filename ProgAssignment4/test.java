package ProgAssignment4;

import java.io.Console;
import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		MagicNumber testMagic = new MagicNumber();
		testMagic.setClassification("QA");
		testMagic.setSubclassification("76");
		testMagic.setCopy("2");
		MagicNumber testMagic2 = new MagicNumber("qa.23.12314.2");
		System.out.println(testMagic.toString());
		System.out.println(testMagic2);
		
		Book booktest = new Book(testMagic2, "Tyler", "UCSB", "how to code", "2011", "cs");
		System.out.println(booktest);
		
		Catalog catalog = new Catalog();
		catalog.addBook(booktest);
		
		Operations operationTest = new UserOperations(catalog);
		operationTest.search("tYl");
		
		ArrayList<Book> booklist = new ArrayList<Book>();
		//Users userTest = new Users();
		Users studentTest = new Students(123 ,345 , "tye", "manza", "1233" ,catalog);
		((Students)studentTest).setBooklist("2014/11/24:QA.76.794562.1,2014/11/27:QA.76.943744.1,2014/12/3:QA.76.933653.1");
		//userTest.addUser(studentTest);
		//studentTest.addUser(userTest);
		//System.out.println(userTest);
		System.out.println(studentTest);
//		studentTest.checkOut(testMagic2);
//		studentTest.checkOut(testMagic2);
//		studentTest.showInfo();
//		Users ProfTest = new Professors(123 ,345 , "tyePro", "Santa Cruz", "1233" ,catalog);
//		((Professors)ProfTest).setBooklist("2014/11/24:QA.76.794562.1,2014/11/27:QA.76.943744.1,2014/12/3:QA.76.933653.1");
//		ProfTest.showInfo();

	}

}
