package matrix;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

	ArrayList<Point> coordinates = new ArrayList<>();
	Queue<Integer> queue = new LinkedList<>();
	
	boolean[][] marked;
	int[][] matrix = {
			{ 4, 2, 2, 5 },
			{ 5, 2, 3, 1 },
			{ 4, 2, 6, 2 },
			{ 8, 1, 3, 2 }
		};
	int[] parent;
	
	public void bfs(int row, int column) {
		
		int initialValue = matrix[row][column];
		coordinates.add(new Point(row, column));
		queue.add(row);
		queue.add(column);
		marked[row][column] = true;
		
		while (!queue.isEmpty()) {
			int value = queue.poll();
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[j].length; j++) {
					if (matrix[][] == coordinates && !marked[i][j]) {

						marked[i][j] = true;
						queue.add(i);
						queue.add(j);
//						coordinates.add(new Point([][]));
				}
				}
			}
		}
		
		System.out.println(coordinates);
	}
	
}
