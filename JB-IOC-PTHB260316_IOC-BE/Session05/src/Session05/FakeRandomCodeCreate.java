package Session05;

import java.util.Random;
import java.util.Scanner;

public class FakeRandomCodeCreate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter length (1-1000): ");
		int n = 0;
		if (sc.hasNextInt()) {
			n = sc.nextInt();
		}
		sc.close();
		if (n < 1 || n > 1000) {
			return;
		}
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int r = rnd.nextInt(62); // 0-61
			char c;
			if (r < 26) {
				c = (char) ('A' + r);
			} else if (r < 52) {
				c = (char) ('a' + (r - 26));
			} else {
				c = (char) ('0' + (r - 52));
			}
			sb.append(c);
		}
		System.out.print(sb.toString());
	}
}
