package annagrams;

import java.util.Scanner;

public class Calculation {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Введите двузначное число: ");
		int i = scanner.nextInt();
		int sum = ((i - (i%10)) / 10) + (i%10); 
		
		System.out.println("sum = " + sum);
	}
}
