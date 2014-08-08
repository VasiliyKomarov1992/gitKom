package matrix;

import java.util.Arrays;

public class BalancePoint {

	public static void main(String[] args) {

		int[] array = { 1, 3, 4, 1, 2, 6, };

		System.out.println("Для массива: " + Arrays.toString(array));

		for (int i = 0; i < array.length; i++) {
			if (sum(array, i) == 1) {
				System.out
						.println("Точка баланса: "
								+ i);
			} else {
				System.out.println("Точка баланса не найдена.");
			}

		}
	}

	private static int sum(int[] a, int number) {

		int sumLeft = 0;
		int sumRight = 0;
		int equal;

		for (int i = 0; i < number; i++) {
			sumLeft += a[i];
		}
		System.out.println("result1 -> " + sumLeft + "\n");

		for (int j = number - 1; j > number; j--) {
			sumRight += a[j];
			System.out.println(sumRight);
		}

		if (sumLeft == sumRight) {
			equal = 1;
		} else {
			equal = 0;
		}
		return equal;
	}
}
