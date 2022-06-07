package hust.soict.dsai.aims.media;

import java.time.LocalDate;

public class DigitalVideoDisc extends Disc implements Playable {




public DigitalVideoDisc(String title, String category, float cost, int length, int director, LocalDate date,
			int length2) {
		super(title, category, cost, length, director);
		this.date = date;
		length = length2;
		nbDigitalVideoDisc++;
	}
private static int nbDigitalVideoDisc=0;
LocalDate date= LocalDate.now();
private int length;
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
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
@Override
public void play() {
	System.out.println("Playing DVD: " + this.getTitle());
	System.out.println("DVD length: " + this.getLength());
	
}

}

