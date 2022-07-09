package hust.soict.globalict.aims.media;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import hust.soict.globalict.aims.exception.MediaException;

public class Book extends Media{
	private String content;
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
public int count_freq(String str)
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
        for(Map.Entry<String,Integer> entry:
    	wordFrequency.entrySet())
    {
        count+=entry.getValue();
    }
    return count;
}
public void setContent(String content) {
	this.content = content;
	this.processContent();
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
			+ authors + "-" + getCost()+"$-"+LocalDate.now()+"-"+this.wordFrequency.toString()+"-"+count_freq(this.getTitle())/2;
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
public Book(String title, String category, float cost, List<String> authors) throws MediaException {
	super(title, category, cost);
	this.authors = authors;
}



}
