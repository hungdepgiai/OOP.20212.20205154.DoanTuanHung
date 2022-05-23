package hust.soict.dsai.lab01;
import java.util.*;
public class Triangle {
	public static void main(String[] args) {
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter n:");
		n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			{
				for(int j = 0; j <= i; j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	
}
