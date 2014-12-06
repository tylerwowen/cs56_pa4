package ProgAssignment4;

import java.util.ArrayList;

public class Users {
	private ArrayList<Users> userList;
	protected String name,
		address,
		phoneNumber;
	protected int ID;
	protected ArrayList<Book> booklist;
	protected Operations operations; 
	
	public Users(){
		userList = new ArrayList<Users>();
	}
	public Users(String name, String address, String phoneNumber, int iD) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		ID = iD;
		userList = new ArrayList<Users>();
	}
	
	public void addUser(Users user){
		userList.add(user);
	}
	
	public void checkOut(Book book){
		operations.checkOut( book);
	}
	public void returnBook(Book book){
		operations.returnBook( book);
	}
	public void search(String keyword){
		operations.search( keyword);
	}
	public void showInfo(){
		operations.showInfo();
	}
	@Override
	public String toString() {
		String result="";
		for (Users user: userList){
			result= user.name + user.address;
		}
		return result;
	}
}
