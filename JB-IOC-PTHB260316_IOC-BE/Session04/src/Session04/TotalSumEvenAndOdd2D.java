package Session04;

import java.util.Scanner;
public class TotalSumEvenAndOdd2D {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Insert the number of rows: ");
		int r = sc.nextInt();
		System.out.print("Insert the number of columns: ");
		int c = sc.nextInt();
		int[][] a = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print("Element [" + (i + 1) + "][" + (j + 1) + "]: ");
				a[i][j] = sc.nextInt();
			}
		}
		int sumEven = 0, sumOdd = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (a[i][j] % 2 == 0) sumEven += a[i][j]; else sumOdd += a[i][j];
			}
		}
		System.out.println("Sum of even numbers: " + sumEven);
		System.out.println("Sum of odd numbers: " + sumOdd);
		sc.close();
	}
}
