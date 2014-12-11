package ProgAssignment4;

import java.util.ArrayList;

public class Librarians extends Users{
	private int PIN;

	public Librarians(int iD, int pIN, String name, String address, String phoneNumber, 
			 Catalog catalog) {
		super(name, address, phoneNumber, iD);
		PIN = pIN;
		operations = new LOperations(catalog);
		policy = new LibPolicy();
	}
	
	public Librarians() {
		super();
	}

	public void L2(CommonUsers cu, int blockUser){
		((LOperations) operations).L2(cu, blockUser);
	}
	
	public void L3(ArrayList<Users> users){
		((LOperations) operations).L3(users);
	}
	
	public boolean comparePIN(int pin){
		if (pin == PIN)
			return true;
		return false;
	}
}
