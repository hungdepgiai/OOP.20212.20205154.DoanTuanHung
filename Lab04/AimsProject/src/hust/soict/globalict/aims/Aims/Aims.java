package hust.soict.globalict.aims.Aims;
import hust.soict.globalict.aims.cart.Cart.cart;

import hust.soict.globalict.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import java.util.*;
public class Aims {
	public static Store b=new Store();
	public static cart anOrder = new cart();	
	public static void showMenu() 
	{System.out.println("AIMS: ");
	System.out.println("--------------------------------");
	System.out.println("1. View store");
	System.out.println("2. Update store");
	System.out.println("3. See current cart");
	System.out.println("0. Exit");
	System.out.println("--------------------------------");
	System.out.println("Please choose a number: 0-1-2-3");
	}
	public static void cartMenu() 
	{
		
		System.out.println("Options: ");
	System.out.println("--------------------------------");
	System.out.println("1. Filter DVDs in cart");
	System.out.println("2. Sort DVDs in cart");
	System.out.println("3. Remove DVD from cart");
	System.out.println("4. Place order");
	System.out.println("0. Back");
	System.out.println("--------------------------------");
	System.out.println("Please choose a number: 0-1-2-3-4");}
	
	public static void storeMenu() 
	{System.out.println("Options: ");
	System.out.println("--------------------------------");
	System.out.println("1. See a DVD’s details");
	System.out.println("2. Add a DVD to cart");
	System.out.println("3. See current cart");
	System.out.println("0. Back");
	System.out.println("--------------------------------");
	System.out.println("Please choose a number: 0-1-2-3");}
	public static void Menu()
	{
		
		int option=10;
		int option2=10;
		int option3=10;
		int option4=10;
		int option5=10;
		int option6=10;
		int option7=10;
		int i;
		Scanner sc=new Scanner(System.in);
		showMenu();
		while(option!=0)
		{
			//Aims: view store, update store, see cart, exit
		option= sc.nextInt(); 
		switch(option) {
		
		case 1:
			b.print();
			storeMenu();
			int d=0;
			while(option4!=0)
			{
				//view store: see dvd detail, add to cart, see current cart,back
				option4=sc.nextInt();
				switch(option4) {
				case 1:
					System.out.println("Enter a disc you want to find, in word:");
					sc.nextLine();
					String title = sc.nextLine();
					anOrder.Search(title);	
					break;
					
				case 2:
					System.out.println("Enter a disc you want to buy, in word:");
					sc.nextLine();
					String title2 = sc.nextLine();
					anOrder.Search2(title2);	
					break;
				case 3:
					anOrder.print();
					break;
				case 0:
					Menu();
					break;
				}
			}
			break;
		case 2:
			System.out.println("Press 1 for add, 2 for remove,3 for add all:");
			option2=sc.nextInt();
			System.out.println("For dvd 1,2,3,4,5,6,7,8 press their respective number to add/remove:");
			option5=sc.nextInt();
			for(i=0;i<8;i++)
			{
				if (option2==1 &&option5==i) b.addDVD(b.dvd[i]);
				else if (option2==2 &&option5==i) b.removeDVD(b.dvd[i]);
				if(option2==3) b.addDVD(b.dvd[i]);
			}
			Menu();
			break;
			
		case 3:
			anOrder.print();
			while(option3!=0)
			{
				cartMenu();
			option3=sc.nextInt();
			switch(option3) {
			//cart: filter dvd, sort dvd, remove dvd, place order, back
			case 1:
				System.out.println("I can't do this part!");
				break;
			case 2:
				System.out.println("Press 1 for sort title, 2 for sort cost:");
				option7=sc.nextInt();
				if(option7==1) 
					{
					anOrder.SortByTitle();
					anOrder.print();
					}
				else if(option7==2) 
					{
					anOrder.SortByCost();
					anOrder.print();
					}
				Menu();
				break;
			case 3:
				System.out.println("For dvd 1,2,3,4,5,6,7,8 press their respective number to remove:");
				option6=sc.nextInt();
				for(i=0;i<anOrder.qtyOrdered;i++)
				{
					if (option6==i) 
						{
						anOrder.removeDigitalVideoDisc(anOrder.itemsOrdered[i]);
						anOrder.print();
						}
				}
				Menu();
				break;
			case 4:System.out.println("Order placed");
			for(i=0;i<anOrder.qtyOrdered;i++)
			{
				anOrder.removeDigitalVideoDisc(anOrder.itemsOrdered[i]);
			}
			break;
			case 0:Menu();
			break;
			}
			}
		case 0:
			System.out.println("The end");
			break;
			}
		}
	}
	public static void main(String[]args)
	{
		Menu();
	}
	}
