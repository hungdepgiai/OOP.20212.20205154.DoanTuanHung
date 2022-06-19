package hust.soict.globalict.test.media;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class TestMediaCompareTo {

	public static void main(String[] args) {
		ArrayList <DigitalVideoDisc> collection=new ArrayList<DigitalVideoDisc>(); 
		DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion King","Animation",19.95f,87,"Roger Allers");
		DigitalVideoDisc dvd2= new DigitalVideoDisc("Star Wars","Science Fiction",24.95f,87,"George Lucas");
		DigitalVideoDisc dvd3= new DigitalVideoDisc("Mickey","Cartoon",17.8f,45,"Walt Disney");
		collection.add(dvd1);collection.add(dvd2);collection.add(dvd3);
		java.util.Iterator iterator=collection.iterator();
		System.out.println("--------------------------------------");
		System.out.println("The DVDs currently in the order are:");
		while(iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
	java.util.Collections.sort((java.util.List)collection);
	iterator=collection.iterator();
	System.out.println("-------------------------------------------");
System.out.println("The DVDs in sorted order are:");
while(iterator.hasNext()) {
	System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
}
System.out.println("---------------------------------------------------");
}
}
