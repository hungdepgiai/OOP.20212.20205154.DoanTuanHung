import java.util.Scanner;
import javax.swing.JOptionPane;
public class Calculator{
public static void main(String args[])
{
double a, b;
		System.out.print("Enter a:");
		a = STDIN_SCANNER.nextDouble();
		System.out.print("Enter b:");
		b = STDIN_SCANNER.nextDouble();
		System.out.printf("Sum =%f\n", a + b);
		System.out.printf("Difference=%f\n", a - b);
		System.out.printf("Multiplication=%f\n", a * b);
		System.out.printf("Division=%f\n", a / b);
}
public final static Scanner STDIN_SCANNER = new Scanner(System.in);
}