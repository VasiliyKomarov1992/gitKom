package matrix;

import java.util.Arrays;

public class BalancePoint {

	public static void main(String[] args) {

		int[] array = { 1, 3, 4, 1, 2, 6, };
		
		System.out.println("Для массива: " + Arrays.toString(array));

		for (int i = 0; i < array.length; i++) {
			if (sum(array, i) == 1) {
				System.out.println("Точка баланса в массиве находится под номером: " + i);
			} else {
				System.out.println("Точка баланса не найдена.");
			}
			
		}
	}

 	private static int sum(int[] a, int number) {

		int result1 = 0;
		int result2 = 0;
		int equal;

		for (int i = 0; i < number; i++) {
			result1 += a[i];
		}
		System.out.println("result1 -> " + result1 + "\n");

		for (int j = a.length + 1; j < a.length; j++) {
			result2 += a[j];
			System.out.println(result2);
		}

		if (result1 == result2) {
			equal = 1;
		} else {
			equal = 0;
		}
		return equal;
	}
}
