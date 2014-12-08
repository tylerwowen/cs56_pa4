package ProgAssignment4;

import java.util.NoSuchElementException;

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
	
	public MagicNumber(String str) throws NoSuchElementException{
		String[] tokens = str.split("\\.");		
		classification = tokens[0];
		subclassification = tokens[1];
		serial = tokens[2];
		copy = tokens[3];
	}
	@Override
	public String toString() {
		return classification + "." + subclassification + "." + serial + "." + copy;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getSubclassification() {
		return subclassification;
	}

	public void setSubclassification(String subclassification) {
		this.subclassification = subclassification;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getCopy() {
		return copy;
	}

	public void setCopy(String copy) {
		this.copy = copy;
	}
	
}
