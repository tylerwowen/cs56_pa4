package ProgAssignment4;


public class Professors extends CommonUsers{
	private int PIN;

	public Professors(int iD, int pIN, String name, String address, String phoneNumber, 
			 Catalog catalog) {
		super(iD, name, address, phoneNumber, catalog);
		PIN = pIN;
		policy = new ProfPolicy();
	}
	public Professors() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean comparePIN(int pin) {
		if (pin == PIN)
			return true;
		return false;
	}
}
