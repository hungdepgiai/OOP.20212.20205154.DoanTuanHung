package hust.soict.dsai.aims.media;

import java.time.LocalDate;

public class Media {
	private static int nbmedia=0;
	LocalDate date =LocalDate.now(); 
	private int id;
	private String title;
	private String category;
	private float cost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getNbmedia() {
		return nbmedia;
	}
	public void setNbmedia(int nbmedia) {
		this.nbmedia = nbmedia;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	private static int get_number() {
		return nbmedia;
	}
	public Media(int id, String title, String category, float cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbmedia++;
	}
	public boolean search(String title) {
		String[] tokens =title.split(" ");
		for(String token:tokens) {
			if(!this.getTitle().contains(token))
				return false;
		}
		return true;
}


