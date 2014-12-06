package ProgAssignment4;

import java.util.ArrayList;

public class Professors extends Users{
	private int PIN;
	
	public Professors(String name, String address, String phoneNumber, int iD,
			int pIN,  ArrayList<Book> booklist, Catalog catalog) {
		super(name, address, phoneNumber, iD);
		PIN = pIN;
		operations = new UserOperations(catalog);
		this.booklist = booklist;
	}

}
