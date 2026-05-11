package Session05;

import java.util.Scanner;

public class EmailFormatCheck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter email: ");
		String input = sc.nextLine();
		sc.close();
		String email = input == null ? "" : input.trim();
		String pattern = "^[A-Za-z0-9._]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*\\.[A-Za-z]{2,6}$";
		if (email.matches(pattern)) {
			System.out.println("Email is valid");
		} else {
			System.out.println("invalid email");
		}
	}
}
