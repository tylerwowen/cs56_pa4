package ProgAssignment4;

import java.util.ArrayList;

public class UserOperations implements Operations {
	protected Catalog catalog;

	public UserOperations(Catalog catalog) {
		this.catalog = catalog;
	}

	@Override
	public boolean  search(String keyword) {
		ArrayList<Book> collection = catalog.getCollection();
		for (Book book: collection){
			if (book.toString().toLowerCase().contains(keyword.toLowerCase())){
				System.out.println("haha");
			}
		}
		return false;
	}

	@Override
	public void checkOut(Book book) {
		System.out.println("haha");// TODO Auto-generated method stub

	}

	@Override
	public void returnBook(Book book) {
		System.out.println("haha");// TODO Auto-generated method stub

	}

	@Override
	public void showInfo() {
		System.out.println("haha");// TODO Auto-generated method stub

	}

}
