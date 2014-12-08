package ProgAssignment4;


public class Students extends CommonUsers{
	private int PIN;

	public Students(int iD, int pIN, String name, String address, String phoneNumber, 
			 Catalog catalog) {
		super(iD, name, address, phoneNumber, catalog);
		PIN = pIN;
		policy = new StudentPolicy();
	}
	public Students() {
		// TODO Auto-generated constructor stub
	}
	public boolean comparePIN(int pin){
		if (pin == PIN)
			return true;
		return false;
	}
}
