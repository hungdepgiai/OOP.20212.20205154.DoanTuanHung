package hust.soict.globalict.aims.Aims;
import hust.soict.globalict.aims.Store.Store;
import hust.soict.globalict.aims.book.Book;
import hust.soict.globalict.aims.cart.Cart.cart;
import hust.soict.globalict.aims.cd.CompactDisc;
import hust.soict.globalict.aims.dvd.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.MemoryDaemon;
import java.util.*;
public class Aims {
	
	public static Store b=new Store();
	public static cart anOrder = new cart();	
	public static MemoryDaemon a=new MemoryDaemon(); 
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
		int choice2=10;
	System.out.println("Enter media title you want to play:");
	Scanner sc=new Scanner(System.in);
	String choice =sc.nextLine();
	Media media1=anOrder.search(choice);
	if(media1!=null) {
		media1.play();
	}
	else {
		System.out.println("No media will be played");
	}
		System.out.println("Options: ");
	System.out.println("--------------------------------");
	System.out.println("1. Filter medias in cart");
	System.out.println("2. Sort medias in cart");
	System.out.println("3. Remove media from cart");
	System.out.println("4. Place order");
	System.out.println("0. Back");
	System.out.println("--------------------------------");
	System.out.println("Please choose a number: 0-1-2-3-4");
	choice2=sc.nextInt();
	switch(choice2) {
	case 1:
		System.out.println("1. Filter by id");
		System.out.println("2. Filter by title");
		System.out.println("Choose 1 or 2:");
		int choice3=sc.nextInt();
		switch(choice3) {
		default:
			System.out.println("Invalid value");
			System.exit(0);
		case 1:
			System.out.println("Enter id to filter");
			int choice4=sc.nextInt();
			anOrder.searchbyid(choice4);
			break;
		case 2:
			System.out.println("Enter title to filter:");
			sc.nextLine();
			String choice5=sc.nextLine();
			anOrder.searchbytitle(choice5);
			break;
		}
		break;
	case 2:
		System.out.println("1 for sort by title, 2 for sort by cost");
		int choice6=sc.nextInt();
		switch(choice6) {
		default:
		System.out.println("Invalid input");
		System.exit(0);
		break;
		case 1:
			anOrder.SortByTitle();
			anOrder.print();
			cartMenu();
			break;
		case 2:
			anOrder.SortByCost();
			anOrder.print();
			cartMenu();
			break;
		}
		break;
	case 3:
		System.out.println("Enter media you want to remove:");
		String choice7=sc.nextLine();
		anOrder.removeMedia(choice7);
		break;
	case 4:
		Media item=anOrder.getALuckyItem();
		if(item==null) {
			System.out.println("Order created,total cost"+anOrder.totalCost());
			anOrder.Empty();
		}
		else {
		System.out.println("This item is free");
		System.out.println(item.toString());
		System.out.println("Order created,total cost:"+anOrder.totalCost()+"$");
		anOrder.Empty();
		System.exit(0);
		}
		break;
	case 0:
		Menu();
		break;
	default:
		System.out.println("Invalid value");
		break;
	}
	}
	public static void storeMenu() 
	{
	Scanner sc=new Scanner(System.in);
		System.out.println("Enter media title to play:");
	String choice3=sc.nextLine();
	Media media1=b.searchByTitle(choice3);
	if(media1!=null) {
		media1.play();
	}
	else {
		System.out.println("No media played");
	}
	System.out.println("Options: ");
	System.out.println("--------------------------------");
	System.out.println("1. See a media's details");
	System.out.println("2. Add a media to cart");
	System.out.println("3. See current cart");
	System.out.println("0. Back");
	System.out.println("--------------------------------");
	System.out.println("Please choose a number: 0-1-2-3");
	int choice = sc.nextInt();
	switch(choice) {
	case 1:
		System.out.println("Enter media title:");
		String choice2=sc.nextLine();
		Media media=b.searchByTitle(choice2);
		System.out.println(media);
		if(media==null) {
			System.out.println("Title not found");
			System.exit(0);
		}
		else {
			Aims.decision();
			int choice4=sc.nextInt();
			switch(choice4) {
			case 1:
				anOrder.addMedia(media);
				break;
			case 2:
				break;
			default:
			System.out.println("Invalid input");
			break;
			}
		}
		showMenu();
	case 2: 
		System.out.println("Enter media title");
		sc.nextLine();
		String choice5=sc.nextLine();
		Media dvd1=b.searchByTitle(choice5);
		if(dvd1==null) {
		System.out.println("Title not found");	
		Menu();
		}
		else {
			System.out.println("Media found:"+dvd1.toString());
			anOrder.addMedia(dvd1);
			anOrder.print();
		}

		Menu();
		break;
	case 3:
		anOrder.print();
		cartMenu();
	case 0: 
		Menu();
		break;
	}
	}
	public static void decision() {
		System.out.println("Do you want to add this dvd to cart?");
		System.out.println("1.Yes");
		System.out.println("2.No");
	}
	public static void Menu()
	{
		Scanner sc=new Scanner(System.in);
		showMenu();
		
		int option= sc.nextInt(); 
		switch(option) {
		
		case 1:
			b.print();
			Aims.storeMenu();
			break;
		case 2:
					System.out.println("1 for add, 2 for remove media");
					int choice=sc.nextInt();
					switch(choice) {
					default: System.out.println("Invalid input");
					System.exit(0);
					break;
					case 1:
						System.out.println("1.DVD");
						System.out.println("2.Book");
						System.out.println("3.CD");
						int choice2=sc.nextInt();
						switch(choice2) {
						case 1:
							sc.nextLine();
							System.out.println("Title:");
							String choice3=sc.nextLine();
							System.out.println("Category:");
							String choice4=sc.nextLine();
							System.out.println("Director:");
							String choice5=sc.nextLine();
							System.out.println("Length");
							int choice6=sc.nextInt();
							System.out.println("Cost");
							float choice7=sc.nextFloat();
							DigitalVideoDisc disc=new DigitalVideoDisc(choice3,choice4,choice7,choice6,choice5);
							b.addmedia(disc);
							break;
						case 2:
							sc.nextLine();
							System.out.println("Title:");
							String choice8=sc.nextLine();
							System.out.println("Category:");
							String choice9=sc.nextLine();
							System.out.println("Cost:");
							float choice10=sc.nextFloat();
							sc.nextLine();
							System.out.println("Authors name,split by comma:");
							String choice11=sc.nextLine();
							List<String>b1=new ArrayList<>(Arrays.asList(choice11.split(",")));
							Book book=new Book(choice8,choice9,choice10,b1);
							b.addmedia(book);
							break;
						case 3:
							sc.nextLine();
							System.out.println("Title:");
							String choice12=sc.nextLine();
							System.out.println("Category:");
							String choice13=sc.nextLine();
							System.out.println("Artist:");
							String choice14=sc.nextLine();
							System.out.println("Director:");
							String choice15=sc.nextLine();
							System.out.println("Cost:");
							float choice16=sc.nextFloat();
							CompactDisc cd=new CompactDisc(choice12,choice13,choice16,choice15,choice14);
							b.addmedia(cd);
							break;
						}
						break;
					case 2: 
						System.out.println("Enter title to be removed:");
						sc.nextLine();
						String choice17=sc.nextLine();
						b.removemedia(choice17);
					break;
					}
				case 3:
					anOrder.print();
					cartMenu();
					break;
				case 0:
					System.out.println("The end");
					System.exit(0);
					break;
				}
			}
		
		
	public static void main(String[]args)
	{	
		
		DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion King","Animation",19.95f,87,"Roger Allers");
		DigitalVideoDisc dvd2= new DigitalVideoDisc("Star Wars","Science Fiction",24.95f,87,"George Lucas");
		ArrayList<String>authors=new ArrayList<String>();
		authors.add("Hung");
		authors.add("Hien");
		Book book=new Book("Don quixote","Novel",18.67f,authors);
		CompactDisc cd1=new CompactDisc("a","b",23f,4,"d","o");
		CompactDisc cd2=new CompactDisc("e","f",22f,5,"h","q");
		CompactDisc cd3=new CompactDisc("i","j",21f,6,"l","r");
		CompactDisc cd4=new CompactDisc("m","n",20f,7,"p","s");
		b.addmedia(dvd1,dvd2,book);
		anOrder.addMedia(cd1,cd2,cd3,cd4);
		Menu();
	}
	}
