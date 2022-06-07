package hust.soict.dsai.aims.media;

public class Disc extends Media {

	private int length;
	private int director;
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getDirector() {
		return director;
	}
	public void setDirector(int director) {
		this.director = director;
	}
	public Disc(String title, String category, float cost, int length, int director) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}
	
	}
	
	

