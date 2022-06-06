package hust.soict.globalict.test.cart.CartTest;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class test {
	public static ArrayList<Mammal> p = new ArrayList<Mammal>();
	static Mammal a=new Mammal(3,5);
	static Mammal b=new Mammal(4,6);
	static Mammal c=new Mammal(1,3);
	public static void main(String[]args) {
		p.add(a);
		p.add(b);
		p.add(c);
		System.out.println(p.get(0).getSize());
	}

}
