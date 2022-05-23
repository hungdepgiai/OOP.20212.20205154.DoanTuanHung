package hust.soict.dsai.lab01;

import java.util.Scanner;
public class Matrix {
	public static void main(String[] args) {
		int[][] a = new int[100][100], b = new int[100][100], c = new int[100][100];
		int row, col;
		System.out.print("Number of rows:");
		row = STDIN_SCANNER.nextInt();
		System.out.print("Number of columns:");
		col = STDIN_SCANNER.nextInt();
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print("Enter element a[" + i + "][" + j + "]:");
				a[i][j] = STDIN_SCANNER.nextInt();
			}
		}
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print("Enter element b[" + i + "][" + j + "]:");
				b[i][j] = STDIN_SCANNER.nextInt();
			}
		}
		System.out.println("Matrix a:");
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Matrix b:");
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Matrix sum:");
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				c[i][j] = a[i][j] + b[i][j];
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}

	public final static Scanner STDIN_SCANNER = new Scanner(System.in);
}

