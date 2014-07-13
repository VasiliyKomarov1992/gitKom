package ArrayExample;

public class ArrayExample {

	double[] x = {10, 20, 30, 40, 55, 56.45};
	
	private void increaseArray() {
		
		for (int i = 0; i < x.length; i++) {
			x[i] += (x[i] * 0.1);
			System.out.println("a[i] = " + x[i]);
		}
	}
	
	public static void main(String[] args) {
		
		ArrayExample ar = new ArrayExample();
		ar.increaseArray();
		
		
	}
	
}
