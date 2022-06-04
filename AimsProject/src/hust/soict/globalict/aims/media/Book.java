package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Book extends Media{
private List<String> authors=new ArrayList<String>();
	
public List<String> getAuthors() {
	return authors;
}

public void setAuthors(List<String> authors) {
	this.authors = authors;
}
public void addAuthor(String authorName) {
	for(int i=0;i<authors.size();i++)
	{
		if (authorName.compareTo(authors.get(i))==0)
		{
			return;
		}
	}
	authors.add(authorName);
}
public void  removeAuthor(String authorName) {
	for(int i=0;i<authors.size();i++)
	{
		if (authorName.compareTo(authors.get(i))==0)
		{
			return;
		}
	}
	authors.remove(authorName);
}
public Book() {
		// TODO Auto-generated constructor stub
	}

}
