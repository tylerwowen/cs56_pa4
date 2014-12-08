package ProgAssignment4;

import java.util.ArrayList;

public class Users {
	protected String name,
		address,
		phoneNumber;
	protected int ID;
	protected ArrayList<Book> booklist;
	protected Operations operations; 
	protected Policy policy;
	protected boolean block;
	
	public Users(){
		
	}
	public Users(String name, String address, String phoneNumber, int iD) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		ID = iD;
		block = false;
	}

	public Users getUser(int id){
		if (id == ID)
			return this;
		return null;
	}

}
