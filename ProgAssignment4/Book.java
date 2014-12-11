package ProgAssignment4;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Book {
	private MagicNumber magicnumber;
	private String authors,
		publisher,
		title,
		year,
		subject;
	private boolean available;
	private Date checkoutDate;
	
	public Book(){
		this.magicnumber = new MagicNumber();
		this.authors = "";
		this.publisher = "";
		this.title = "";
		this.year = "";
		this.subject = "";
		this.available = false;
	}
	public Book(MagicNumber magicnumber, String title, String authors,
			String publisher, String year, String subject) {
		this.magicnumber = magicnumber;
		this.authors = authors;
		this.publisher = publisher;
		this.title = title;
		this.year = year;
		this.subject = subject;
		this.available = true;
	}
	public Book(String str){
		String[] re = str.split("\\:");
		SimpleDateFormat format = new SimpleDateFormat("yyyy/M/d");
		try {
			this.checkoutDate = format.parse(re[0]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		magicnumber = new MagicNumber(re[1]);
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	@Override
	public String toString() {
		return  magicnumber +  authors	+  publisher + title + year + subject ;
	}
	public String toString1(boolean bool) {
		return  "Magic Number: " + magicnumber +
				"\nAuthor(s): "+  authors	+
				"\nPublisher: "+publisher + 
				"\nTitle: "+ title +
				"\nYear: " +year +
				"\nSubject: "+ subject ;
	}

	public MagicNumber getMagicnumber() {
		return magicnumber;
	}

	public String getAuthors() {
		return authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getTitle() {
		return title;
	}

	public String getYear() {
		return year;
	}

	public String getSubject() {
		return subject;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
}
