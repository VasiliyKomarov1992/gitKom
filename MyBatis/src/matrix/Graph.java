package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	
	int vertices;
	int edge;
	int[][] adjacent;
	
	int[][] matrix = new int[][] {
			{4,2,2,5},
			{5,7,3,1},
			{4,2,6,5},
			{8,1,3,7}
	};
	
	public void searchBreadthFirst() {
		Queue<Integer> queue = new LinkedList<>(); // заносим исходную вершину
		while (!queue.isEmpty()) {
			int last = queue.poll();
			for (int i = 0; i < matrix.length; i++) {
				if(matrix[last][i] == 1) {
					queue.add(i);
				}
			}
		}
	}
}
