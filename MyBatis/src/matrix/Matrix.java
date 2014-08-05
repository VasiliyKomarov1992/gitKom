package matrix;

import java.awt.Point;
import java.util.ArrayList;

public class Matrix {

	ArrayList<Point> point = new ArrayList<>();

	boolean[][] marked = new boolean[4][4];

	int[][] matrix = {
			{ 4, 2, 2, 5 },
			{ 5, 2, 3, 1 },
			{ 4, 2, 6, 8 },
			{ 8, 1, 3, 7 }
		};

	public void searchBreadthFirst(int row, int column) {

		int initialValue = matrix[row][column];
		point.add(new Point(row, column));
		marked[row][column] = true;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[row - 1][j] == initialValue && !marked[row - 1][j]) {

					marked[row - 1][j] = true;
					point.add(new Point(row - 1, j));
					row--;
				}
				if (matrix[row + 1][j] == initialValue && !marked[row + 1][j]) {

					marked[row + 1][j] = true;
					point.add(new Point(row + 1, j));
					row++;
				}
				if (matrix[i][column - 1] == initialValue
						&& !marked[i][column - 1]) {

					marked[i][column - 1] = true;
					point.add(new Point(i, column - 1));
					column--;
				}
				if (matrix[i][column - 1] == initialValue
						&& !marked[i][column + 1]) {

					marked[i][column + 1] = true;
					point.add(new Point(i, column + 1));
					column++;
				}
				System.out.println(point);
			}
		}
	}

	public static void main(String[] args) {

		Matrix matrix = new Matrix();
		matrix.searchBreadthFirst(2, 1);
	}
}
