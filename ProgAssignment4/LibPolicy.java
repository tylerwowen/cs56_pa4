package ProgAssignment4;

public class LibPolicy implements Policy {

	@Override
	public int applyPolicy() {
		System.out.println("You cannot checkout a book!!");
		return 0;
	}

}
