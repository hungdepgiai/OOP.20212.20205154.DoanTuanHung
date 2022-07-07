package hust.soict.globalict.aims.media;

import java.time.LocalDate;

import hust.soict.globalict.aims.disc.Disc;
import hust.soict.globalict.aims.playable.Playable;

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
	this.dateadded = LocalDate.now();
}
private static int get_number() {
	return nbDigitalVideoDisc;
}
@Override
public void play() {
	if (this.getLength() <= 0 ) {
		System.out.println("Can't play " + this.getTitle());
	}
	else {
	System.out.println("Playing DVD: " + this.getTitle());
	System.out.println("DVD length: " + this.getLength());
	}
}



}

