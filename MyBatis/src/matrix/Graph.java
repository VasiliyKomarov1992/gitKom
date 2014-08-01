package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	
	int vertices;
	int edge;
	int[][] initialValue;
	
	int[][] matrix = {
			{4,2,2,5},
			{5,2,3,1},
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
//http://java-study.ru/java-uchebnik/96-mnogomernye-massivy
//http://www.policyalmanac.org/games/aStarTutorial_rus.htm