package matrix;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

	ArrayList<Point> coordinates = new ArrayList<>();
	Queue<Point> queue = new LinkedList<>();
	
	boolean[][] marked;
	int[][] matrix;
	
	public void bfs(int[][] mat, int row, int column) {
		matrix = mat;
		int initialValue = mat[row][column];
		
		queue.add(new Point(row, column));
		
		while (!queue.isEmpty()) {
			Point value = queue.poll();
			coordinates.add(value);
			marked[value.x][value.y] = true;
			for (Point sosed : sosedi) {
				if (matrix[sosed.x][sosed.y] == matrix[value.x][value.y]) {
					queue.add(sosed);
				}
			}
		}
		
		System.out.println(coordinates);
	}
	
}
