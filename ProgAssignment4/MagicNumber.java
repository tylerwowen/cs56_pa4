package ProgAssignment4;


public class MagicNumber {
	public String classification,
	subclassification,
	serial,
	copy;
	
	public MagicNumber(){
		this.classification = "";
		this.subclassification = "";
		this.serial = "";
		this.copy = "";
	}
	
	public MagicNumber(String str) throws ArrayIndexOutOfBoundsException{
		String[] tokens = str.split("\\.");	
		try{
		classification = tokens[0];
		subclassification = tokens[1];
		serial = tokens[2];
		copy = tokens[3];
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid maigic number");
			throw e;
		}
	}
	@Override
	public String toString() {
		return classification + "." + subclassification + "." + serial + "." + copy;
	}
}
