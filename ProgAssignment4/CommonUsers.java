package ProgAssignment4;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CommonUsers extends Users {
	protected Catalog catalog;
	CommonUsers(int iD,  String name, String address, String phoneNumber, 
			 Catalog catalog) {
		super(name, address, phoneNumber, iD);
		operations = new UserOperations(catalog);
		booklist = new ArrayList<Book>();
		this.catalog = catalog;
	}
	
	public CommonUsers(){		
		super();
	}

	public boolean checkOut(MagicNumber mgn){
		if (!block ){
			if (operations.checkOut( mgn)){
				addBook(mgn);
				return true;
			}
			return false;
		}
		else
			System.err.println("Sorry, you are blocked!");
		return false;
	}
	public void returnBook(MagicNumber mgn){
		if (this.removeBook(mgn))
			operations.returnBook( mgn);
	}
	public void search(String keyword){
		operations.search( keyword);
	}
	public void showInfo(){
		String info = "\nUser Information\nName: "+name+
					"\nAddress: "+address+
					"\nPhone Number: "+phoneNumber+
					"\nID: "+ID+
					"\nBlocking Status: "+block + "\n\nBookList: ";
		SimpleDateFormat format = new SimpleDateFormat("yyyy/M/d");
		Calendar c = Calendar.getInstance();
		for (Book bk: booklist){		
			c.setTime(bk.getCheckoutDate());
			c.add(Calendar.DATE, policy.applyPolicy());
			if (operations.getBook(bk.getMagicnumber().toString()) != null)
			info += "\n" + operations.getBook(bk.getMagicnumber().toString()).toString1(true) 
				+ "\nDue Date:" + format.format(c.getTime()) + "\n"; 
		}
		System.out.println(info);
	}
	
	public void setBooklist(String str){
		if (str.isEmpty())
			return;
		String[] bkl = str.split("\\,");
		for(int i=0; i<bkl.length;i++){
			Book bk = new Book(bkl[i]), bk2=new Book();
			booklist.add(bk);
			if ((bk2 = operations.getBook(bk.getMagicnumber().toString())) != null){
				if (bk2.isAvailable()){
					bk2.setAvailable(false);
				}
			}
		}
	}
	
	public boolean removeBook(MagicNumber mgn){
		for (int i=0; i< booklist.size(); i++){
			if (booklist.get(i).getMagicnumber().toString().equals(mgn.toString())){
				booklist.remove(i);
				System.out.println("\nSuccessfully returned a book\n");
				return true;
			}
		}
		System.out.println("\nYou do not have this book!\n");
		return false;
	}
	
	public void addBook(MagicNumber mgn){
		SimpleDateFormat format = new SimpleDateFormat("yyyy/M/d");
		Book bk = new Book(format.format(this.catalog.getDate())+":"+mgn.toString());
		booklist.add(bk);
		System.out.println("Book added to your account.");
	}
	
	public void setBlock(){
		this.block = true;
	}
	public boolean comparePIN(int PIN){
		return false;
	}

}