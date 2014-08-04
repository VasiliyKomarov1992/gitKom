package matrix;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix {

	boolean[] marked;

	int[][] matrix = {
			{ 4, 2, 2, 5 },
			{ 5, 2, 3, 1 },
			{ 4, 2, 6, 5 },
			{ 8, 1, 3, 7 }
		};

	public void searchBreadthFirst(int r, int c) {
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Point> point = new ArrayList<>();
		
		int initialValue = matrix[r][c];
		
		point.add(new Point(r,c));
		System.out.println(point);
		
		queue.add(initialValue);
		marked[initialValue] = true;

		while (!queue.isEmpty()) {
			int value = queue.peek();
			queue.remove();
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					if (matrix[r - 1][j] == matrix[r][c]
							&& !marked[matrix[r - 1][j]]) {

						marked[matrix[r - 1][j]] = true;
						queue.add(matrix[r - 1][j]);
						
						System.out.println(queue);
						
					} else if (matrix[r + 1][j] == matrix[r][c]
							&& !marked[matrix[r + 1][j]]) {
						
						marked[matrix[r + 1][j]] = true;
						queue.add(matrix[r + 1][j]);
						
						System.out.println(queue);
					}
				}
			}
		}
	}

	public static void main(String[] args) {

		Matrix mat = new Matrix();
//		System.out.println(mat.matrix[2][3]);
		mat.searchBreadthFirst(2, 3);
	}
}

// if (matrix[r - 1][j] == matrix[r][c]
// || matrix[r + 1][j] == matrix[r][c]) {
// queue.add(i);
// System.out.println(queue);
// } else if (matrix[i][c - 1] == matrix[r][c]
// || matrix[i][c + 1] == matrix[r][c]) {
// queue.add(j);
// System.out.println(queue);
