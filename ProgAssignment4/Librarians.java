package ProgAssignment4;

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
		// TODO Auto-generated constructor stub
	}

	public void L1(){
		((Librarians) operations).L1();
	}
	public void L2(){
		((Librarians) operations).L2();
	}
	public void L3(){
		((Librarians) operations).L3();
	}
	public boolean comparePIN(int pin){
		if (pin == PIN)
			return true;
		return false;
	}
}
