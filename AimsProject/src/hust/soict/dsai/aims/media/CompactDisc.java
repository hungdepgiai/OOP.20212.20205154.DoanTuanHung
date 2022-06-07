package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
private String artist;
private ArrayList<Track> tracks = new ArrayList<Track>();
int count=0;
public String getArtist() {
	return artist;
}
public void setArtist(String artist) {
	this.artist = artist;
}
public CompactDisc(String title, String category, float cost, int length, int director, String artist,
		ArrayList<Track> tracks) {
	super(title, category, cost, length, director);
	this.artist = artist;
	this.tracks = tracks;
}
public void addTrack(Track track) {
	int i,flag=0;
	for(i=0;i<tracks.size();i++) {
		if (tracks.get(i).getTitle().equals(track.getTitle())) {
			{
				flag=1;
				tracks.add(track);
			System.out.println("Track added");
			break;
			}
		}
	}
	if(flag==0) System.out.println("Track not found");
		
	}
public void removeTrack(Track track) {
	int i,flag=0;
	for(i=0;i<tracks.size();i++) {
		if (tracks.get(i).getTitle().equals(track.getTitle())) {
			{
				flag=1;
				tracks.remove(track);
			System.out.println("Track removed");
			break;
			}
		}
	}
	if(flag==0)System.out.println("Track not found");
}
public int getLength() {
	int i;
	for(i=0;i<tracks.size();i++) {
		count+=tracks.get(i).getLength();
	}
	return count;
}
@Override
public void play() {
	// TODO Auto-generated method stub
	
}
}
