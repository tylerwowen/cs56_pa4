package ProgAssignment4;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class LOperations extends UserOperations {
	public LOperations(Catalog catalog) {
		super(catalog);
	}

	public void L2(CommonUsers cu, int blockUser){		
		if (blockUser==1)
			cu.block=true;
		else if (blockUser==0)
			cu.block=false;
		System.out.println("User "+cu.ID+ " is" +((cu.block)? " " : " un")+"blocked");
	}
	
	public void L3(ArrayList<Users> users){
		for (Users user: users){
			if (user.getClass().equals(Librarians.class))
				break;
			for(Book bk: user.booklist){
				Calendar c = Calendar.getInstance();
				c.setTime(bk.getCheckoutDate());
				c.add(Calendar.DATE, user.applyPolicy());
				Date dueDate = c.getTime();
				if (catalog.getDate().after(dueDate))
					System.out.println(user.name);
			}
		}
		System.out.println();	
	}
}