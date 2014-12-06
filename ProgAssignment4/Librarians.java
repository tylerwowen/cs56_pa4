package ProgAssignment4;

public class Librarians extends Users{
	private int PIN;

	public Librarians(String name, String address, String phoneNumber, int iD,
			int pIN, Catalog catalog) {
		super(name, address, phoneNumber, iD);
		PIN = pIN;
		operations = new LOperations(catalog);
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
}
