import java.util.Scanner;
public class Triangle {
	public static void main(String[] args) {
		int n;
		System.out.print("Enter n:");
		n = STDIN_SCANNER.nextInt();
		for(int i = 0; i < n; i++) {
			{
				for(int j = 0; j <= i; j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	public final static Scanner STDIN_SCANNER = new Scanner(System.in);
}

