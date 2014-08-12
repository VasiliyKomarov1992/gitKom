package matrix;

public class BalancePoint {

	int[] array = { 1, 3, 4, 1, 2, 6 };

	public int searchBalance() {
		int[] sumRight = new int[array.length];
		int[] sumLeft = new int[array.length];

		sumLeft[0] = array[0];
		sumRight[array.length - 1] = array[array.length - 1];
		
		for (int i = 1; i < array.length - 1; i++) {
			sumLeft[i] = sumLeft[i - 1] + array[i];
			System.out.println("sumLeft = " + sumLeft[i]);
		}

		for (int i = array.length - 2; i > 0; i--) {
			sumRight[i] = sumRight[i + 1] + array[i];
			System.out.println("sumRight = " + sumRight[i]);
		}

		for (int i = 0; i < sumLeft.length; i++) {
			System.out.println("sumLeft: " + sumLeft[i] + " - " + "sumRight: "
					+ sumRight[i]);
			if (sumLeft[i] == sumRight[i]) {
				return i;
			}
		}
		return 1;
	}

	public static void main(String[] args) {

		BalancePoint point = new BalancePoint();
		System.out.println("Точка баланса: " + point.searchBalance());

	}
}
