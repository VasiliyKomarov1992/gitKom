package matrix;

import java.util.Arrays;

public class BalancePointExampleThree {

	int[] array = { 1, 3, 4, 1, 2, 6, };

	public int balanceSearch() {
		System.out.println("Для массива: " + Arrays.toString(array));

		int sumLeft = 0;
		int sumRight = 0;
		int equal = 0;

		for (int i = 0; i < array.length; i++) {
			for (int m = 0; m < i; m++) {
				sumLeft += array[m];
			}
			for (int m = i; m < array.length; m++) {
				sumRight += array[m];
			}
			if (sumLeft == sumRight) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		BalancePointExampleThree ex = new BalancePointExampleThree();
		System.out.println(ex.balanceSearch());

	}

}

// for (int k = array.length - 1; k > 0; k--) {
// resultR += array[k];
// }