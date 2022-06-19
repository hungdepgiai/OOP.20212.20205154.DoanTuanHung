package hust.soict.globalict.aims.Store;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class Store {
	public ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	int i;
	public static final int MAX_NUMBERS=30;
	public Media searchByTitle(String title) {
		int flag=0;
		for(Media x:this.itemsOrdered) {
		if(x.search(title)) {
			flag++;
			System.out.println("Title found:"+title);
			System.out.println(x);
			return x;
		}
	}
		if(flag==0) {
			System.out.println("Media not found");
		}
		return null;
	}
	public void sortbytitle() {
		this.itemsOrdered.sort((a,b)->{
			int cmp=a.getTitle().compareTo(b.getTitle());
					if (cmp!=0) return cmp;
			cmp=-Math.round(a.getCost()-b.getCost());
			return cmp;
		});
		System.out.println("Ordered items:");
		this.print();
	}
	public void print()
	{
		int i;
		System.out.println("***********************STORE***********************");
		System.out.println("Store items:");
		for( Media x:this.itemsOrdered)
		{
			if(x==null) continue;
			System.out.println(x.toString());
		}
		System.out.println("**************************************************");
	}
	public void addmedia(Media ... medias)
	{
		int size=0;
		for(int i=0;i<medias.length;i++) {
			if(this.itemsOrdered.size()<MAX_NUMBERS) {
				boolean a=true;
				for(Media x:this.itemsOrdered) {
					if(x==medias[i]) a=false;
			}
				if(a) {
					this.itemsOrdered.add(medias[i]);
					this.itemsOrdered.get(i).setDateAdded(LocalDate.now());
					size++;
				}
				else {
					System.out.println(medias[i].getTitle()+" is already added");
				}
		}
	}
		System.out.println(size+" medias are added successfully!");
	}
	public void removemedia(String title)
	{
		if(itemsOrdered.size()==0)
		{
			System.out.println("Cart empty");
			return;
		}
		List<Media>toRemove=new ArrayList<Media>();
		for(Media x:this.itemsOrdered) {
			if (x.getTitle().equals(title))
			{
				toRemove.add(x);
			}
		}
			this.itemsOrdered.removeAll(toRemove);
			System.out.println("Media with title "+title+ " has been removed");
	}
	public void Empty() {
		this.itemsOrdered.removeAll(itemsOrdered);
	}
	public ArrayList<Media> getItemsInStore() {
		return itemsOrdered;
	}
}
