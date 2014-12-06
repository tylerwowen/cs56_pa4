package ProgAssignment4;

import java.util.ArrayList;

public class Catalog {
	private ArrayList<Book> collection;
	
	public Catalog() {
		this.collection = new ArrayList<Book>();
	}
	

	public void addBook(Book book){
		collection.add(book);
	}
	
	public ArrayList<Book> getCollection() {
		return collection;
	}
}
