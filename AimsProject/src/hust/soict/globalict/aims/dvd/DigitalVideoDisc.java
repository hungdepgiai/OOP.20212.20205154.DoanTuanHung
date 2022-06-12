package hust.soict.globalict.aims.dvd;

import java.time.LocalDate;

import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Playable;

public class DigitalVideoDisc extends Disc implements Playable {
public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
		super(title, category, cost, length, director);
	}
private static int nbDigitalVideoDisc=0;
private LocalDate dateadded;
public LocalDate getDateadded() {
	return dateadded;
}
public void setDateadded(LocalDate dateadded) {
	this.dateadded = dateadded;
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

