package matrix;

import java.util.*;

class Balans {
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int a[] = new int[reader.nextInt()];
		int x = reader.nextInt(), y = reader.nextInt();
		zapolni(a, x, y);
		System.out.println(Arrays.toString(a));
		for (int i = 1; i < a.length - 1; i++) {
			if (sum(a, i) == 1) {
			}
			System.out.println(a[i] + " - точка баланса");
		}
	}

	static int sum(int[] b, int k) {
		int s = 0, s1 = 0, v;
		for (int i = 0; i < k; i++)
			s = s + b[i];
		for (int j = k + 1; j < b.length; j++)
			s1 = s1 + b[j];
		if (s == s1)
			v = 1;
		else
			v = 0;
		return v;
	}

	static void zapolni(int[] l, int m, int n) {
		for (int i = 0; i < l.length; i++)
			l[i] = m + (int) (n * Math.random());
	}
}