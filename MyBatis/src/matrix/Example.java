package matrix;

import java.util.Arrays;

public class Example {

	public static void main(String[] args) {

		int[] array = { 1, 3, 4, 1, 2, 6, };
		int[] sumLeft = new int[array.length];

		
		System.out.println("Для массива: " + Arrays.toString(array));

		for (int i = 1; i < array.length - 1; i++) {
			sumLeft[i] = sumLeft[i-1] + array[i];
			System.out.println(sumLeft[i]);
	}
	}
	
}
