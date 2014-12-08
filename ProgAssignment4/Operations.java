package ProgAssignment4;

public interface Operations {
	boolean search(String keyword);
	boolean checkOut(MagicNumber mgn);
	void returnBook(MagicNumber mgn);
	Book getBook(String keyword);
}
