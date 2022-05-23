package hust.soict.globalict.aims.Aims;

import java.util.Scanner;

import hust.soict.globalict.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Store {
	public DigitalVideoDisc itemsInStore[]= new DigitalVideoDisc[100];
	public int qtyinstore=0;
	int i;
	DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
	DigitalVideoDisc dvd2= new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
	DigitalVideoDisc dvd3= new DigitalVideoDisc("Aladin","Animation",18.99f);
	DigitalVideoDisc dvd4= new DigitalVideoDisc("AAAA","aaaa","aaaa",1,5.6f);
	DigitalVideoDisc dvd5= new DigitalVideoDisc("BBBB","bbbb","bbbb",2,5.3f);
	DigitalVideoDisc dvd6= new DigitalVideoDisc("CCCC","cccc","cccc",3,5f);
	DigitalVideoDisc dvd7= new DigitalVideoDisc("DDDD","dddd","dddd",4,7.1f);
	DigitalVideoDisc dvd8= new DigitalVideoDisc("EEEE","eeee","eeee",5,3.3f);
	DigitalVideoDisc[] dvd= {dvd1,dvd2,dvd3,dvd4,dvd5,dvd6,dvd7,dvd8};
	
	public void print()
	{
		int i;
		System.out.println("***********************STORE***********************");
		System.out.println("Store items:");
		for( i=0;i<qtyinstore;i++)
		{
			System.out.println("DVD-"+itemsInStore[i].getTitle()+"-"+itemsInStore[i].getDirector()+"-"+itemsInStore[i].getLength()+"-"+itemsInStore[i].getCost()+"$");
		}
		System.out.println("**************************************************");
	}
	public void addDVD(DigitalVideoDisc disc)
	{
		if(qtyinstore<= 100)
		{
			itemsInStore[qtyinstore]=disc;
			qtyinstore +=1;
		}
		else {
			System.out.printf("Store full!");
		}
	}
	public void removeDVD(DigitalVideoDisc disc)
	{
		if(qtyinstore>0)
		{
		for(i=0;i<qtyinstore;i++)
		{
		if(itemsInStore[i].getTitle().equals(disc.getTitle()))
		{
			System.arraycopy(itemsInStore,i+1,itemsInStore,i,qtyinstore-i);
			qtyinstore -=1;
			System.out.println("Remove disk "+(i+1)+" successfully!");
			break;
		}
		}
		}
		else System.out.println("Store empty");
	}
}
