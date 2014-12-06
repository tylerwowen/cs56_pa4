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
	
	public MagicNumber(String classification, String subclassification, String serial,
			String copy) {
		this.classification = classification;
		this.subclassification = subclassification;
		this.serial = serial;
		this.copy = copy;
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
