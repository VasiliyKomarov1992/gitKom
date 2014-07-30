package annagrams;

import java.util.Scanner;

public class Calculation {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please, enter the number: ");
		String txt = scanner.nextLine().trim();
		char[] array = txt.toCharArray();
		int sum = 0;
		for (char c : array) {
				sum = sum + Character.getNumericValue(c);
		}
		System.out.println("sum = " + sum);
	}
}
