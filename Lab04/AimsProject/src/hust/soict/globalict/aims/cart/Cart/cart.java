package hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.Aims.Aims;
import hust.soict.globalict.aims.Aims.Store;
import hust.soict.globalict.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import java.util.*;
public class cart {
public static final int MAX_NUMBERS_ORDERED = 20;
private static final String STDIN_SCANNER = null;
public DigitalVideoDisc itemsOrdered[]= new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
private DigitalVideoDisc tmp[]= new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
public int qtyOrdered=0;
int qty=0;
float price=0;
int i;
Aims e=new Aims();
public void addDigitalVideoDisc(DigitalVideoDisc disc)
{
	
	if(qtyOrdered<= MAX_NUMBERS_ORDERED)
	{
		
		itemsOrdered[qtyOrdered]=disc;
		qtyOrdered +=1;
		System.out.printf("Add disk "+qtyOrdered+" successfully!\n");
	}
	else {
		System.out.printf("Cart full!");
	}
}
public void Search(String title)
{
	int option;
	int d=0;
	int i,c,a=0;
	Scanner sc=new Scanner(System.in);
	
	for(i=0;i<e.b.qtyinstore;i++)
	{
	 c = e.b.itemsInStore[i].getTitle().indexOf(title);
	 if(c>=0) 
	 {
		 a=1;
		 System.out.println("DVD-"+e.b.itemsInStore[i].getTitle()+"-"+e.b.itemsInStore[i].getDirector()+"-"+e.b.itemsInStore[i].getLength()+"-"+e.b.itemsInStore[i].getCost()+"$");
		 System.out.println("Do you want to buy? 1 for yes, 2 for no:");
		 option=sc.nextInt();
		 if(option==1) addDigitalVideoDisc(e.b.itemsInStore[i]);
		 if(option==2) break;
		 break;
	 }
	}
	if(a==0)System.out.println("Disk not found");
}
public void Search2(String title)
{
	int option;
	int d=0;
	int i,c,a=0;
	Scanner sc=new Scanner(System.in);
	
	for(i=0;i<e.b.qtyinstore;i++)
	{
	 c = e.b.itemsInStore[i].getTitle().indexOf(title);
	 if(c>=0) 
	 {
		 a=1;
		 System.out.println("DVD-"+e.b.itemsInStore[i].getTitle()+"-"+e.b.itemsInStore[i].getDirector()+"-"+e.b.itemsInStore[i].getLength()+"-"+e.b.itemsInStore[i].getCost()+"$");
		 addDigitalVideoDisc(e.b.itemsInStore[i]);
		 break;
	 }
	}
	if(a==0)System.out.println("Disk not found");
}
public void addDigitalVideoDisc2(DigitalVideoDisc disc1, DigitalVideoDisc disc2)
{
	
	if(qtyOrdered<= MAX_NUMBERS_ORDERED)
	{
		itemsOrdered[qtyOrdered]=disc1;
		qtyOrdered +=1;
		itemsOrdered[qtyOrdered]=disc2;
		qtyOrdered +=1;
		System.out.printf("Add disk successfully!\n");
	}
	else {
		System.out.printf("Cart full!");
	}
}

public void removeDigitalVideoDisc(DigitalVideoDisc disc)
{
	if(qtyOrdered>0)
	{
	for(i=0;i<qtyOrdered;i++)
	{
	if(itemsOrdered[i].getTitle().equals(disc.getTitle()))
	{
		System.arraycopy(itemsOrdered,i+1,itemsOrdered,i,qtyOrdered-i);
		qtyOrdered -=1;
		System.out.println("Remove disk "+(i+1)+" successfully!");
		break;
	}
	}
	}
	else System.out.println("Cart empty");
}
public float totalCost()
{
	for(i=0;i<qtyOrdered;i++)
	{
		price+=itemsOrdered[i].getCost();
	}
	return price;
}
public void SortByCost() {
	int i,j;
	for(i=0;i<qtyOrdered;i++)
	{for(j=i+1;j<qtyOrdered;j++)
	{
		char title1[]=itemsOrdered[i].getTitle().toCharArray();
		char title2[]=itemsOrdered[j].getTitle().toCharArray();
		if(itemsOrdered[i].getCost()==itemsOrdered[j].getCost()){
		if(title1[0]>title2[0])
			{
			tmp[0]=itemsOrdered[i];
			itemsOrdered[i]=itemsOrdered[j];
			itemsOrdered[j]=tmp[0];
		}
		}
		else if(itemsOrdered[i].getCost()>itemsOrdered[j].getCost())
		{
			tmp[0]=itemsOrdered[i];
			itemsOrdered[i]=itemsOrdered[j];
			itemsOrdered[j]=tmp[0];
		}
	}
	}
}
public void SortByLength()
{
	int i,j;
	for(i=0;i<qtyOrdered;i++)
	{for(j=i+1;j<qtyOrdered;j++)
	{
		if(itemsOrdered[i].getLength()<itemsOrdered[j].getLength())
		{
			tmp[0]=itemsOrdered[i];
			itemsOrdered[i]=itemsOrdered[j];
			itemsOrdered[j]=tmp[0];
		}
	}
	}
}
public void SortByTitle()
{
	
	int i,j;
	for(i=0;i<qtyOrdered;i++)
	{for(j=i+1;j<qtyOrdered;j++)
	{
		char title1[]=itemsOrdered[i].getTitle().toCharArray();
		char title2[]=itemsOrdered[j].getTitle().toCharArray();
		if(title1[0]==title2[0])
		{if(itemsOrdered[i].getCost()<itemsOrdered[j].getCost())
		{
			tmp[0]=itemsOrdered[i];
			itemsOrdered[i]=itemsOrdered[j];
			itemsOrdered[j]=tmp[0];
		}
		else if(title1[0]<title2[0])
		{
			tmp[0]=itemsOrdered[i];
			itemsOrdered[i]=itemsOrdered[j];
			itemsOrdered[j]=tmp[0];
		}
		}
	}
	}
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
public void Sort() {
	int i,j;
	for(i=0;i<qtyOrdered;i++)
	{
		for(j=i+1;j<qtyOrdered;j++) 
	{
		char title1[]=itemsOrdered[i].getTitle().toCharArray();
		char title2[]=itemsOrdered[j].getTitle().toCharArray();
	if (title1[i]==title2[j])
	{
		if(itemsOrdered[i].getCost()==itemsOrdered[j].getCost())
		{
			if(itemsOrdered[i].getLength()>=itemsOrdered[j].getLength())
			{
				tmp[0]=itemsOrdered[i];
				itemsOrdered[i]=itemsOrdered[j];
				itemsOrdered[j]=tmp[0];
			}
		}
		else {tmp[0]=itemsOrdered[i];
		itemsOrdered[i]=itemsOrdered[j];
		itemsOrdered[j]=tmp[0];}
	}
	else {tmp[0]=itemsOrdered[i];
	itemsOrdered[i]=itemsOrdered[j];
	itemsOrdered[j]=tmp[0];}
    }
	}
	}

public void print()
{
	int i;
	Sort();
	System.out.println("***********************CART***********************");
	System.out.println("Number of disks ordered:"+qtyOrdered);
	System.out.println("Ordered items:");
	for( i=0;i<qtyOrdered;i++)
	{
		System.out.println("DVD-"+itemsOrdered[i].getTitle()+"-"+itemsOrdered[i].getDirector()+"-"+itemsOrdered[i].getLength()+"-"+itemsOrdered[i].getCost()+"$");
	}
	System.out.println("Total cost:"+totalCost()+"$");
	System.out.println("**************************************************");
}
}
