package matrix;

public class BalancePointExampleTwo {

	int[] array = { 2, 3, 4, 1, 3, 6 };

	public void searchBalance() {

		int indexLeft = 0;
		int indexRight = array.length - 1;
		int sumLeft = array[0];
		int sumRight = array[array.length - 1];

		while (indexLeft != indexRight) {
			if (sumLeft <= sumRight) {
				sumLeft += array[++indexLeft];
				System.out.println("sumleft: " + sumLeft);
			} else {
				sumRight += array[--indexRight];
				System.out.println("sumright: " + sumRight);
			}
		}
		if (sumLeft == sumRight) {
			System.out.println("Точка баланса в координате:" + indexLeft
					+ ", " + indexRight + "\n" + "Сумма равна: " + " левая: " + sumLeft + ", правая: " + sumRight);
		}
	}

	public static void main(String[] args) {
		BalancePointExampleTwo bp = new BalancePointExampleTwo();
		bp.searchBalance();
	}
}
