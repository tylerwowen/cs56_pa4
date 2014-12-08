package ProgAssignment4;

import java.util.ArrayList;

public class UserOperations implements Operations {
	protected Catalog catalog;

	public UserOperations(Catalog catalog) {
		this.catalog = catalog;
	}

	@Override
	public boolean search(String keyword) {
		ArrayList<Book> collection = catalog.getCollection();
		ArrayList<Book> result = new ArrayList<Book>();
		for (Book book: collection){
			if (book.toString().toLowerCase().contains(keyword.toLowerCase())){
				result.add(book);				
			}
		}
		if (!result.isEmpty()){
			System.out.println("\nAvailable books:\n");
			for (Book book : result){			
				if (book.isAvailable()){				
					System.out.println(book.toString1(true));
					System.out.println();
				}
			}

			System.out.println("\nNOT available books:\n");
			for (Book book : result){			
				if (!book.isAvailable()){				
					System.out.println(book.toString1(true));
					System.out.println();
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean checkOut(MagicNumber mgn) {
		// todo check block
		Book bk = new Book();
		if ((bk = getBook(mgn.toString())) != null){
			if (bk.isAvailable()){
				bk.setAvailable(false);
				System.out.println("Book checked out.");
				return true;
			}
			System.out.println("Book is NOT available! Come back later\n");
			return false;
		}
		System.out.println("Book does not exist.\n");
		return false;
	}

	@Override
	public void returnBook(MagicNumber mgn) {
		Book bk = new Book();
		if ((bk = getBook(mgn.toString())) != null){
			bk.setAvailable(true);		
		}		
	}


	@Override
	public Book getBook(String keyword){
		for (Book book: catalog.getCollection()){
			if (book.toString().toLowerCase().contains(keyword.toLowerCase())){
				return book;
			}
		}
		return null;
	}

}
