package daycount;
import java.util.Scanner;
public class daycount {
	public static void main(String[] args) {
		int month, year;
		boolean leap;
		System.out.print("Enter month(in number):");
		month = STDIN_SCANNER.nextInt();
		System.out.print("Enter year:");
		year = STDIN_SCANNER.nextInt();
		if(year % 400 == 0) {
			leap = true;
		} else if(year % 100 == 0) {
			leap = false;
		} else if(year % 4 == 0) {
			leap = true;
		} else {
			leap = false;
		}
		if(month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.print("Month has 30 days");
		} else if(month == 2 && !leap) {
			System.out.print("Month has 28 days");
		} else if(month == 2 && leap) {
			System.out.print("Month has 29 days");
		} else {
			System.out.print("Month has 31 days");
		}
	}

	public final static Scanner STDIN_SCANNER = new Scanner(System.in);
}
