package hust.soict.globalict.aims.cart.Cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.globalict.aims.Aims.Aims;
public class cart {
public static final int MAX_NUMBERS_ORDERED = 20;
private static final String STDIN_SCANNER = null;
int qty=0;
float price=0;
int i;
public static Aims e=new Aims();

public ArrayList<Media> itemsOrdered = new ArrayList<Media>();
public ArrayList<Media> tmp = new ArrayList<Media>();
public void addMedia(Media media) {
	if(itemsOrdered.size()==MAX_NUMBERS_ORDERED-1) {
		System.out.println("Cart full");
	}
	else if(itemsOrdered.size()<MAX_NUMBERS_ORDERED) {
		itemsOrdered.add(media);
		System.out.println("Add disk"+itemsOrdered.size()+"successfully");
	}
	
}
public void search() {
	int i,flag=0;
	String a;
	System.out.println("Enter title:");
	Scanner sc = null;
	a=sc.nextLine();
	for(i=0;i<itemsOrdered.size();i++) {
	if (itemsOrdered.get(i).search(a)==true) {
		System.out.println("Media found:"+itemsOrdered.get(i).getTitle()+"-"+itemsOrdered.get(i).getCost()+"$" );
		addMedia(itemsOrdered.get(i));
		flag=1;
		break;
	}
	}
	if(flag==0) System.out.println("Disk not found");
}
public void removeMedia(Media media) {
	if(itemsOrdered.size()==MAX_NUMBERS_ORDERED-1) {
		System.out.println("Cart empty");
	}
	else if(itemsOrdered.size()<MAX_NUMBERS_ORDERED) {
		itemsOrdered.remove(media);
		System.out.println("Remove disk"+itemsOrdered.size()+"successfully");
	}
}

public float totalCost()
{
	for(i=0;i<itemsOrdered.size();i++)
	{
		price+=itemsOrdered.get(i).getCost();
	}
	return price;
}
public void SortByCost() {
	int i,j;
	for(i=0;i<itemsOrdered.size();i++)
	{for(j=i+1;j<itemsOrdered.size();j++)
	{
		char title1[]=itemsOrdered.get(i).getTitle().toCharArray();
		char title2[]=itemsOrdered.get(j).getTitle().toCharArray();
		if(itemsOrdered.get(i).getCost()==itemsOrdered.get(j).getCost()){
		if(title1[0]>title2[0])
		{
			Collections.swap(itemsOrdered, i, j);
		}
		}
		else if(itemsOrdered.get(i).getCost()>itemsOrdered.get(j).getCost())
		{
			Collections.swap(itemsOrdered, i, j);
		}
	}
	}
}

public void SortByTitle()
{
	
	int i,j;
	for(i=0;i<itemsOrdered.size();i++)
	{for(j=i+1;j<itemsOrdered.size();j++)
	{
		char title1[]=itemsOrdered.get(i).getTitle().toCharArray();
		char title2[]=itemsOrdered.get(j).getTitle().toCharArray();
		if(title1[0]==title2[0])
		{if(itemsOrdered.get(i).getCost()<itemsOrdered.get(j).getCost())
		{
			Collections.swap(itemsOrdered, i, j);
		}
		else if(title1[0]<title2[0])
		{
			Collections.swap(itemsOrdered, i, j);
		}
		}
	}
	}
}
public Media getALuckyItem(){
    if(itemsOrdered.size()==0)return null;
    int luck= (int)(Math.random()*itemsOrdered.size());
    luck--;
    itemsOrdered.get(luck).setCost(0F);
    return itemsOrdered.get(luck);
    
}
public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[]dvdlist)
{
	String[] titlelist=new String[dvdlist.length];
	DigitalVideoDisc[] newdvdlist = new DigitalVideoDisc[dvdlist.length];
	for(int i=0;i<dvdlist.length;i++)
	{
		titlelist[i]=dvdlist[i].getTitle();
		newdvdlist[i]=dvdlist[i];
	}
	return newdvdlist;
}


public void print()
{
	int i;
	System.out.println("***********************CART***********************");
	System.out.println("Number of disks ordered:"+itemsOrdered.size());
	System.out.println("Ordered items:");
	for( i=0;i<itemsOrdered.size();i++)
	{
		System.out.println("DVD-"+itemsOrdered.get(i).getTitle()+"-"+itemsOrdered.get(i).getCost()+"$");
	}
	System.out.println("Total cost:"+totalCost()+"$");
	System.out.println("**************************************************");
}
}
