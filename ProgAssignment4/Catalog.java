package ProgAssignment4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Catalog {
	private ArrayList<Book> collection;
	private Date date;
	
	public Catalog() {
		this.collection = new ArrayList<Book>();
	}
	

	public void addBook(Book book){
		collection.add(book);
	}
	
	public ArrayList<Book> getCollection() {
		return collection;
	}
		
	public void setDate(String str) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy/M/d");
		try {
			this.date = format.parse(str);
		} catch (ParseException e) {
			throw e;
		}
	}
	public Date getDate(){
		return date;
	}
}
