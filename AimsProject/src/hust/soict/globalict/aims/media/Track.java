package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.playable.Playable;

public class Track implements Playable,Comparable<Track> {
private String title;
private int length;
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getLength() {
	return length;
}
public void setLength(int length) {
	this.length = length;
}
public Track(String title, int length) {
	super();
	this.title = title;
	this.length = length;
}
public boolean equals(Object track1) {
	if (track1 instanceof Track) {
		Track track2=(Track) track1;
		if (track2.getTitle()==this.getTitle() && this.getLength()==track2.getLength()) {
			return true;
		}
	}
	return false;
}
@Override
public String toString() {
	return "Track: " + title + "-" + length;
}
public void play() {
	if(this.getLength()>0) {
	System.out.println("Playing DVD: " + this.getTitle());
	System.out.println("DVD length: " + this.getLength());
	}
	}
@Override
public int compareTo(Track o) {
	return this.getTitle().compareTo(o.getTitle());
}

}
