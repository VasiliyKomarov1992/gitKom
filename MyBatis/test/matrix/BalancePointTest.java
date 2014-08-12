package matrix;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BalancePointTest {

	BalancePointExampleTwo point = new BalancePointExampleTwo();
	int[] array;

	@Test
	public void testOne() {
		array = new int[]{ 2, 3, 4, 1, 3, 6 };
		assertEquals(3, point.searchBalance(array));
	}
}
