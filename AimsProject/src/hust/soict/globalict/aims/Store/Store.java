package hust.soict.globalict.aims.Store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	int i;
	
	
	public void print()
	{
		int i;
		System.out.println("***********************STORE***********************");
		System.out.println("Store items:");
		for( i=0;i<itemsInStore.size();i++)
		{
			System.out.println("DVD-"+itemsInStore.get(i).getTitle()+"-"+itemsInStore.get(i).getCost()+"$");
		}
		System.out.println("**************************************************");
	}
	public void addmedia(Media media)
	{
		if(itemsInStore.size()<= 100)
		{
			itemsInStore.add(media);
		}
		else {
			System.out.printf("Store full!");
		}
	}
	public void removemedia(Media media)
	{
		if(itemsInStore.size()>0)
		{
		for(i=0;i<itemsInStore.size();i++)
		{
		if(itemsInStore.get(i).getTitle().equals(media.getTitle()))
		{
			System.arraycopy(itemsInStore,i+1,itemsInStore,i,itemsInStore.size()-i);
			System.out.println("Remove disk "+(i+1)+" successfully!");
			break;
		}
		}
		}
		else System.out.println("Store empty");
	}
}
