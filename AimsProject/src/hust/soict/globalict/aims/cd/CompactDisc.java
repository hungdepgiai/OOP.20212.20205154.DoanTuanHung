package hust.soict.globalict.aims.cd;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.Track.Track;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Playable;

public class CompactDisc extends Disc implements Playable {
private int id;
	private String artist;
private ArrayList<Track> tracks = new ArrayList<Track>();
int count=0;
public String getArtist() {
	return artist;
}
public static final int max_track=10;
public void setArtist(String artist) {
	this.artist = artist;
}



public CompactDisc(String title, String category, float cost, int length, String artist) {
	super(title, category, cost, length);
	this.artist = artist;
}
public CompactDisc(String title, String category, float cost, String director, String artist) {
	super(title, category, cost, director);
	this.artist = artist; 
}
public CompactDisc(String title, String category, float cost, int length, String director, String artist) {
	super(title, category, cost, length, director);
	this.artist = artist;
}


@Override
public String toString() {
	return "CompactDisc-" + getTitle() + "-" + artist + "-" + getCategory()+ "-" + getCost()+"-"+getLength()+"-"+getDirector()+"-"+getArtist();
}
public void addTrack(Track ... track ) {
	int i,flag=0;
	int count=0;
	for(i=0;i<tracks.size();i++) {
		if(this.tracks.size()<CompactDisc.max_track) {
			boolean a=true;
			for(Track x:this.tracks) {
				if (x==track[i]) a=false;
			}
			if(a) {
				this.tracks.add(track[i]);
				count++;}
			else {
				System.out.println(track[i].getTitle());
			}
			}
		}
		System.out.println(count+ "disc has been added to cart");
	}
public void removeTrack(String title) {
	if(this.tracks.size()==0) {
		System.out.println("CD is empty");
		return;
	}
	List<Track>toRemove=new ArrayList<Track>();
	for(Track x:this.tracks) {
		if(x.getTitle().equals(title)) {
			toRemove.add(x);
		}
	}
this.tracks.removeAll(toRemove);
System.out.println("All media removed");
}
public int getLength2() {
	if(this.tracks==null) {	
	}
	else {
		for(Track x:this.tracks) {
			count+=x.getLength();
		}
	}
	return count;
}
@Override
public void play() {
	System.out.println("Playing CD:"+this.getTitle());
	System.out.println("CD length:"+this.getLength());
	for(Track x:this.tracks) {
		x.play();
	}
	
}




}
