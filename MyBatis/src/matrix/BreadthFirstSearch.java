package matrix;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

	Queue<Point> queue = new LinkedList<>();
	ArrayList<Point> sosedi = new ArrayList<>();

	boolean[][] marked = new boolean[4][6];
	int[][] matrix = {
			{ 4, 1, 5, 6, 7, 4 },
			{ 1, 3, 3, 3, 4, 5 },
			{ 4, 3, 5, 6, 7, 5 },
			{ 3, 5, 6, 3, 4, 5 },
		};

	public void bfs(int row, int column) {

		int pointStarting = matrix[row][column];
		System.out.println("pointStarting -> " + pointStarting);

		queue.add(new Point(row, column));

		while (!queue.isEmpty()) {

			Point coordinates = queue.poll();
			System.out.println("Coordinats: " + "[" + coordinates.x + ","
					+ coordinates.y + "]");
			marked[coordinates.x][coordinates.y] = true;

			searchNeighbor(coordinates.x, coordinates.y, pointStarting);

			for (Point sosed : sosedi) {
				if (matrix[sosed.x][sosed.y] == matrix[coordinates.x][coordinates.y]
						&& !marked[sosed.x][sosed.y]) {
					queue.add(sosed);
				}
			}
		}
		System.out.println("- - - - - - - - - ");
	}

	public void searchNeighbor(int row, int column, int pointStarting) {

		try {
			if (matrix[row + 1][column] == pointStarting) {
				sosedi.add(new Point(row + 1, column));
			}
			if (matrix[row - 1][column] == pointStarting) {
				sosedi.add(new Point(row - 1, column));
			}
			if (matrix[row][column + 1] == pointStarting) {
				sosedi.add(new Point(row, column + 1));
			}
			if (matrix[row][column - 1] == pointStarting) {
				sosedi.add(new Point(row, column - 1));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("arrayIndexOutOfBoundsException");
			if(row == matrix.length - 1 && column == matrix[row].length - 1) {
	            // что-то делаем ещё
	 }
		}
	}
	public static void main(String[] args) {

		BreadthFirstSearch b = new BreadthFirstSearch();
		b.bfs(2, 1);
		b.bfs(3, 5);
	}
}
