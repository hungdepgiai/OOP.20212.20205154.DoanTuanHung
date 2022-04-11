import java.util.Scanner;
import javax.swing.JOptionPane;
public class Equation{
public static void main(String args[])
{
double a, b, c, d, e, x1, x2, delta;
		System.out.println("Solve equation ax+b=0:");
		System.out.print("Enter a:");
		a = STDIN_SCANNER.nextDouble();
		System.out.print("Enter b:");
		b = STDIN_SCANNER.nextDouble();
		if(a == 0) {
			System.out.print("No solution");
		} else {
			System.out.printf("Solution: x=%f\n", -b / a);
		}
		System.out.println("Solve equation cx^2+dx+e=0:");
		System.out.print("Enter c:");
		c = STDIN_SCANNER.nextDouble();
		System.out.print("Enter d:");
		d = STDIN_SCANNER.nextDouble();
		System.out.print("Enter e:");
		e = STDIN_SCANNER.nextDouble();
		delta = d * d - 4 * c * e;
		if(c == 0) {
			System.out.print("Invalid value.");
		} else if(delta < 0) {
			System.out.print("No solution");
		} else if(delta == 0) {
			System.out.printf("One solution: x=%f", -d / 2 / c);
		} else {
			System.out.printf("2 solutions: x1=%f,x2=%f", (-d - Math.sqrt(delta)) / 2 / c, (-d + Math.sqrt(delta)) / 2 / c);
		}
	}

	public final static Scanner STDIN_SCANNER = new Scanner(System.in);
}