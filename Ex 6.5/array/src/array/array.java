package array;
import java.util.Scanner;
public class array {
	public static void main(String[] args) {
		double[] a = new double[100];
		double sum, temp;
		int n;
		sum = 0;
		System.out.print("Array size:");
		n = STDIN_SCANNER.nextInt();
		System.out.println("Elements:");
		for(int i = 0; i < n; i++) {
			System.out.print("a[" + i + "]=");
			a[i] = STDIN_SCANNER.nextDouble();
			sum += a[i];
		}
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				if(a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println("Elements arranged increasing order:");
		for(int i = 0; i < n; i++) {
			System.out.printf("%f ", a[i]);
		}
		System.out.println();
		System.out.printf("Sum and avg value of all array elements: %f and %f", sum, sum / n);
	}

	public final static Scanner STDIN_SCANNER = new Scanner(System.in);
}
