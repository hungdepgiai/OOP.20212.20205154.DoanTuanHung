package hust.soict.globalict.aims.media;

public class MediaComparatorByTitleCost {
	public int compare(Media o1, Media o2) {
		if(o1.getTitle().equals(o2.getTitle())) {
			return o1.getCost()>o2.getCost()?1:-1;
		}
		else return o1.getTitle().compareTo(o2.getTitle());
	}
}
