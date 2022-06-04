package hust.soict.dsai.aims.media;

import java.time.LocalDate;

public class DigitalVideoDisc extends Media{
private static int nbDigitalVideoDisc=0;
LocalDate date= LocalDate.now();
public DigitalVideoDisc(String title) {
	super();
	this.title = title;
	
}
public DigitalVideoDisc(String title, String category, float cost) {
	super();
	this.title = title;
	this.category = category;
	this.cost = cost;
}
public DigitalVideoDisc(String title, String category, String director, float cost) {
	super();
	this.title = title;
	this.category = category;
	this.director = director;
	this.cost = cost;
}
public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
	super();
	this.title = title;
	this.category = category;
	this.director = director;
	this.length = length;
	this.cost = cost;
	nbDigitalVideoDisc+=1;
}
private static int get_number() {
	return nbDigitalVideoDisc;
}
boolean isMatch(String title)
{
	char a[]=title.toCharArray();
	return true;
}

}
