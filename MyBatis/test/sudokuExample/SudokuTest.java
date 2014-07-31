package sudokuExample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class SudokuTest {


	@Test
	public void testColumnRow() {
		assertEquals(9, Sudoku.COLUMN);
		assertEquals(9, Sudoku.ROW);
	}

	@Test
	public void testBox() {
		Sudoku sudoku = new Sudoku();
		assertNotNull(sudoku.box);
		assertEquals(9, sudoku.box.length);
		assertEquals(9, sudoku.box[0].length);
	}
	
	@Test
	public void testName() {
		Sudoku sudoku = new Sudoku();
		sudoku.box = new int[][] {
				{8,7,6,	2,5,1,	4,3,9}, 
				{9,5,1,	6,3,4,	8,2,7},
				{3,4,2,	7,8,9,	5,1,6},
				
				{1,3,4,	9,7,5,	6,8,2},
				{5,6,8,	4,1,2,	9,7,3},
				{2,9,7,	8,6,3,	1,5,4},
				
				{4,8,3,	1,2,6,	7,9,5},
				{7,2,9,	5,4,8,	3,6,1}, 
				{6,1,5,	3,9,7,	2,4,8},
		};
		
	}
	
}
