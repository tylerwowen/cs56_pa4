package ProgAssignment4;

public class Book {
	private MagicNumber magicnumber;
	private String authors,
		publisher,
		title,
		year,
		subject;
	
	public Book(MagicNumber magicnumber, String authors, String publisher,
			String title, String year, String subject) {
		super();
		this.magicnumber = magicnumber;
		this.authors = authors;
		this.publisher = publisher;
		this.title = title;
		this.year = year;
		this.subject = subject;
	}

	@Override
	public String toString() {
		return  magicnumber +  authors	+  publisher + title + year + subject ;
	}
	
}
