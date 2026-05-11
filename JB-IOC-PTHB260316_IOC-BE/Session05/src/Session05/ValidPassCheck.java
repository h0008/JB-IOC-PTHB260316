package Session05;

import java.util.Scanner;

public class ValidPassCheck {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter password: ");
		String input = sc.nextLine();
		sc.close();

		String pwd = input == null ? "" : input.trim();
		String pattern = "^(?=.{8,}$)(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$!%]).*$";
		if (pwd.matches(pattern)) {
			System.out.println("Valid password!");
		} else {
			System.out.println("Invalid password...");
		}
	}
}
