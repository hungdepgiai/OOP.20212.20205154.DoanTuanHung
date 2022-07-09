package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.disc.Disc;
import hust.soict.globalict.aims.exception.MediaException;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.playable.Playable;

public class CompactDisc extends Disc implements Playable {
private int id;
	private String artist;
private ArrayList<Track> tracks = new ArrayList<Track>();
int count=0;
private String info;
public String getArtist() {
	return artist;
}
public static final int max_track=20;
public void setArtist(String artist) {
	this.artist = artist;
}




public CompactDisc (String title, String category, float cost, String artist)throws MediaException {
	super(title, category, cost);
	this.artist = artist; 
}



@Override
public String toString() {
	String a= "CompactDisc-" + getTitle() + "-" + artist + "-" + getCategory()+ "-" + getCost()+"-"+getLength()+"-"+getDirector()+"-"+getArtist()+"-";
	for(Track t:tracks) {
	a+=t.toString();
}
return a;
}
public void addTrack(Track track) {
	if (tracks.contains(track)) {
		System.out.println("Track is already in list");
	}
	else {
		tracks.add(track);
		System.out.println("Track added");
	}
}

public void removeTrack(Track track) {
	if (!tracks.contains(track)) {
		System.out.println("The track does not exist");
	}
	else {
		tracks.remove(track);
		System.out.println("Track removed");
	}
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
public void play() throws PlayerException{
	if(this.getLength() > 0) {
		java.util.Iterator iter = tracks.iterator();
		Track nextTrack;
		while(iter.hasNext()) {
			nextTrack = (Track)iter.next();
			nextTrack.play();
		}
	}else {
		throw new PlayerException("ERROR: CD length is non-positive!");
	}
}




}
