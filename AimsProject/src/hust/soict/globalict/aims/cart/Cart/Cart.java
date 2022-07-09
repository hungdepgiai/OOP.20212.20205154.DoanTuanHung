package hust.soict.globalict.aims.cart.Cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.Aims.Aims;
import hust.soict.globalict.aims.exception.DuplicateException;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.playable.Playable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Cart {
public static final int MAX_NUMBERS_ORDERED = 20;
private static final String STDIN_SCANNER = null;
int i;

public ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
public final ObservableList<Media> sortByTitle() {
	ObservableList<Media> itemsDisplay = this.getItemsOrdered();; // immutability
	Collections.sort(itemsDisplay,Media.COMPARE_BY_TITLE_COST);  
	return itemsDisplay;
}
public void addMedia(Media...medias)throws LimitExceededException,DuplicateException {
	int size=0;
	for(int i=0;i<medias.length;i++) {
	if(itemsOrdered.size()<this.MAX_NUMBERS_ORDERED) {
		boolean a=true;
		for(Media x:this.itemsOrdered) {
			if (x==medias[i]) a=false;
		}
		if(a) {
			this.itemsOrdered.add(medias[i]);
			size++;
		}
		else {
			System.out.println(medias[i].getTitle()+" is already added");
		}
		
	}
	else {
		throw new LimitExceededException("ERROR: The number of " + "media has reached its limit");
	}
	}
}
public Media search(String title) {
	int flag=0;
	for(Media x:this.itemsOrdered) {
		if(x.search(title)) {
			flag++;
			System.out.println("Media found with title:"+title);
			System.out.println(x);
			return x;
		}
	}
	if(flag==0) {
		System.out.println("Media not found");
		return null;
	}
	return null;
}
public void removeMedia(String title) {
	if(itemsOrdered.size()==0) {
		System.out.println("Cart empty");
		return;
	}
	List<Media> toRemove=new ArrayList<Media>();
	for(Media x:this.itemsOrdered) {
		if(x.getTitle().equals(title)) {
			toRemove.add(x);
		}
	}
	itemsOrdered.removeAll(toRemove);
	System.out.println("Media with title "+title+" removed");
}

public float totalCost()
{
	float price=0;
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
    if(itemsOrdered.size()<5) {
    	System.out.println("Items less than 5, no lucky gift");
    	return null;
    }
    else {
    int luck= (int)(Math.random()*itemsOrdered.size());
    luck--;
    itemsOrdered.get(luck).setCost(0F);
    return itemsOrdered.get(luck);
    }
    
}

public void searchbyid(int id) {
	int flag=0;
	for(Media x:this.itemsOrdered) {
		if (x==null) continue;
		if(x.getId()==id) {
			flag++;
			System.out.println("Media found with id:"+id);
			System.out.println(x);
		}
	}
	if(flag==0)System.out.println("No match found");
}
public Media searchItemById(int id) {
	Media result;
	boolean found = false;
	for(Media media: itemsOrdered) {
		if(id == media.getId()) {
			result = media;
			System.out.println(media.toString());
			return result;
		}
	}
	System.out.println("No item with ID: " + id + " found!");
	return null;			
}
public Media searchbytitle(String title) {
	int flag=0;
	for(Media x:this.itemsOrdered) {
		if(x.search(title)) {
			flag++;
			System.out.println("Media found with title:"+title);
			System.out.println(x);
			return x;
		}
	}
	if (flag==0) {
		System.out.println("Media not found");
		return null;
	}
	return null;
}
public ObservableList<Media> searchItemByTitle(String title) {
	boolean found = false;
	ObservableList<Media> matchMedias = FXCollections.observableArrayList();
	for(Media media : itemsOrdered) {
		if(media == null) break;
		if(media.isMatch(title)) {
			matchMedias.add(media);
			found = true;
		}
	}
	if(found) return matchMedias;
	return null;
}
public void print()
{
	System.out.println("***********************CART***********************");
	System.out.println("Ordered items:");
	for(Media x:this.itemsOrdered) {
		if (x==null)continue;
		System.out.println(x.toString());
	}
	System.out.println("Total cost:"+this.totalCost());
	System.out.println("**************************************************");
}
public void Empty() {
	this.itemsOrdered.removeAll(itemsOrdered);
}
public void play(Media media) throws PlayerException {
	if(media instanceof Playable) {
		((Playable) media).play();
	}else {
		System.out.println("Cannot play this type of Media (" + media.toString() + ")");
	}
}
public ObservableList<Media> getItemsOrdered() {
	return this.itemsOrdered;
}
}
