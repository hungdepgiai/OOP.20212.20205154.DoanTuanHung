package hust.soict.dsai.aims.media;

import java.time.LocalDate;

public class DigitalVideoDisc extends Media{

public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
		super(id,title,category,cost);
		// TODO Auto-generated constructor stub
	}
private static int nbDigitalVideoDisc=0;
LocalDate date= LocalDate.now();
private String director;
private int length;
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public String getDirector() {
	return director;
}
public void setDirector(String director) {
	this.director = director;
}
public int getLength() {
	return length;
}
public void setLength(int length) {
	this.length = length;
}
private static int get_number() {
	return nbDigitalVideoDisc;
}

}

