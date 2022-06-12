package hust.soict.globalict.aims.book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import hust.soict.globalict.aims.dvd.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class Book extends Media{
private List<String> contentTokens=new ArrayList<String>();
private List<String> authors=new ArrayList<String>();
Map <String,Integer> wordFrequency = new HashMap<String,Integer>();
public List<String> getAuthors() {
	return authors;
}
Scanner sc = new Scanner(System.in);
public void play() {
	System.out.println("Can't play");
}
public void setAuthors(List<String> authors) {
	this.authors = authors;
}
public void count_freq(String str)
{
    String arr[]=str.split(" ");
    int count=0;
    for(int i=0;i<arr.length;i++)
    {
        if(wordFrequency.containsKey(arr[i]))
        {
        	wordFrequency.put(arr[i], wordFrequency.get(arr[i])+1);
        }
        else
        {
        	wordFrequency.put(arr[i],1);
        }
    }
    System.out.println("Word frequency:");
    for(Map.Entry<String,Integer> entry:
    	wordFrequency.entrySet())
    {
        System.out.println(entry.getKey()+
                " - "+entry.getValue());
        count+=entry.getValue();
    }
    System.out.println("Number of tokens:"+count);
}

public void processContent() {
	count_freq(this.getTitle());	
}
public void addAuthor(String authorName) {
	for(int i=0;i<authors.size();i++)
	{
		if (authorName.compareTo(authors.get(i))==0)
		{
			return;
		}
	}
	this.authors.add(authorName);
}


@Override
public String toString() {
	processContent();
	return "Book-" + getId() + "-" + getTitle() + "-" + getCategory() + "-"
			+ authors + "-" + getCost()+"$-"+LocalDate.now();
}
public void  removeAuthor(String authorName) {
	for(int i=0;i<authors.size();i++)
	{
		if (authorName.compareTo(authors.get(i))==0)
		{
			return;
		}
	}
	this.authors.remove(authorName);
}
public Book(String title, String category, float cost, List<String> authors) {
	super(title, category, cost);
	this.authors = authors;
}



}
