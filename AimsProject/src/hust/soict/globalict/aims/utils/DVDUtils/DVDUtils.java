package hust.soict.globalict.aims.utils.DVDUtils;
import hust.soict.globalict.aims.dvd.DigitalVideoDisc;

public class DVDUtils {
public static float comparebyCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2 )
{
float price1=dvd1.getCost();
float price2=dvd2.getCost();
if(price1>price2) {return price1;}
else return price2;
}
public static String comparebyTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2)
{
char title1[]=dvd1.getTitle().toCharArray();
char title2[]=dvd2.getTitle().toCharArray();
int i=0;
int a=0;
for(i=0;i<dvd1.getTitle().length();i++)
{
	if(title1[i]>title2[i]) a=1;
	else a=0;
}
if(a==1) {return dvd1.getTitle();}
else if(a==0) {return dvd2.getTitle();}
return null;
}
public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[]dvdlist)
{
	float costlist[]=new float[dvdlist.length];
	DigitalVideoDisc[]newdvdlist=new DigitalVideoDisc[dvdlist.length];
	for(int i=0;i<dvdlist.length;i++){
		costlist[i]=dvdlist[i].getCost();
	}
	for(int i=0;i<dvdlist.length;i++) {
		float minCost=costlist[i];
		for(int j=i;j<dvdlist.length;j++) {
			if(costlist[j]>minCost) {
				minCost=costlist[j];
			}
		}
		for(int k=0;k<dvdlist.length;k++) {
			if(minCost==costlist[k]) {
				float tmp=costlist[i];
				costlist[i]=costlist[k];
				costlist[k]=tmp;
			}
		}
	}
	return newdvdlist;
}
public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[]dvdlist)
{
	String[] titlelist=new String[dvdlist.length];
	DigitalVideoDisc[] newdvdlist = new DigitalVideoDisc[dvdlist.length];
	for(int i=0;i<dvdlist.length;i++)
	{
		titlelist[i]=dvdlist[i].getTitle();
		newdvdlist[i]=dvdlist[i];
	}
	return newdvdlist;
	}
}
