package hust.soict.globalict.aims.book;

import java.util.ArrayList;

public class Booktest {

	public static void main(String[] args) {
		ArrayList<String>authors=new ArrayList<String>();
		authors.add("Hung");
		authors.add("Hien");
		Book b1=new Book("Geeks for Geeks","Novel",18.67f,authors);
		b1.processContent();

	}

}
