package annagrams;

public class Eny {
	public static void main(String[] args) {
		int a = 5, b = 7;
		System.out.println("Minimum is " + min(a, b));
	}

	public static int min(int c, int d) {
		int m2;
		if (c < d) {
			m2 = c;
		} else {
			m2 = d;
		}

		return m2;
	}
}
