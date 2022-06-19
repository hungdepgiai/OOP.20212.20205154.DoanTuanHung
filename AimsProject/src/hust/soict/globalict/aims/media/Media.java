package hust.soict.globalict.aims.media;

import java.time.LocalDate;
import java.util.Comparator;

import hust.soict.globalict.aims.Comparator.MediaComparatorByCostTitle;
import hust.soict.globalict.aims.Comparator.MediaComparatorByTitleCost;

public class Media implements Comparable<Media>{
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	private static int nbmedia=0;
	private int id;
	private String title;
	private String category;
	private float cost;
	private LocalDate dateAdded;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
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
	
	private static int get_number() {
		return nbmedia;
	}
	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id=nbmedia;
		this.dateAdded=LocalDate.now();
		nbmedia++;
	}
	
	@Override
	public String toString() {
		return "Media-" + id + "-" + title + "-" + category + "-"+ cost + "$-"
				+ LocalDate.now();
	}
	public Media(String title) {
		super();
		this.title = title;
		this.id=nbmedia;
		this.dateAdded=LocalDate.now();
		nbmedia++;
	}
	public Media(String title, String category) {
		super();
		this.title = title;
		this.category = category;
		this.id=nbmedia;
		this.dateAdded=LocalDate.now();
		nbmedia++;
	}
	
	public boolean equals(Object media1) {
		if (media1 instanceof Media) {
			Media media2=(Media)media1;
		if(this.getId()==media2.getId()) {
			return true;
		}
		}
		return false;
	}
	public boolean search(String title) {
		String[] tokens =title.split(" ");
		for(String token:tokens) {
			if(!this.getTitle().contains(token))
				{
				return false;
				}
		}
		return true;
}
	public void play() {
		System.out.println("Playing media");
	}
	
	public int compareTo(Media o) {
		return this.getTitle().compareTo(o.getTitle());
	}
}


