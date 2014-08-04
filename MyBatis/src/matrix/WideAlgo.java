package matrix;

public class WideAlgo {
	 
    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A'); // 0 
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4
        theGraph.addEdge(0, 1); // AB
        theGraph.addEdge(1, 2); // BC
        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(3, 4); // DE
        System.out.print("Посещения: ");
        theGraph.bfs(); 
        System.out.println();
    }
 
    static class Queue {
        private final int SIZE = 20;
        private final int[] queArray;
        private int front;
        private int rear;
 
        public Queue() {
            queArray = new int[SIZE];
            front = 0;
            rear = -1;
        }
 
        public void insert(int j) // put item at rear of queue
        {
            if (rear == SIZE - 1) {
				rear = -1;
			}
            queArray[++rear] = j;
        }
 
        public int remove() // take item from front of queue
        {
            int temp = queArray[front++];
            if (front == SIZE) {
				front = 0;
			}
            return temp;
        }
 
        public boolean isEmpty() // true if queue is empty
        {
            return (rear + 1 == front || (front + SIZE - 1 == rear));
        }
    }
 
    static class Vertex {
        public char label; // label 
        public boolean wasVisited;
 
        public Vertex(char l) {
            label = l;
            wasVisited = false;
        }
    }
 
    static class Graph {
        private final int MAX_VERTS = 20;
        private final Vertex vertexList[]; // list of vertices
        private final int adjMat[][]; // adjacency matrix
        private int nVerts; // current number of vertices
        private final Queue theQueue;
 
        public Graph() {
            vertexList = new Vertex[MAX_VERTS];
            // adjacency matrix
            adjMat = new int[MAX_VERTS][MAX_VERTS];
            nVerts = 0;
            for (int j = 0; j < MAX_VERTS; j++) {
				// set adjacency
                for (int k = 0; k < MAX_VERTS; k++) {
					// matrix to 0
                    adjMat[j][k] = 0;
				}
			}
            theQueue = new Queue();
        }
 
        public void addVertex(char l) {
            vertexList[nVerts++] = new Vertex(l);
        }
 
        public void addEdge(int start, int end) {
            adjMat[start][end] = 1;
            adjMat[end][start] = 1;
        }
 
        public void displayVertex(int v) {
            System.out.print(vertexList[v].label);
        }
 
        // breadth-first search
        public void bfs() 
        { // begin at vertex 0
            vertexList[0].wasVisited = true; // mark it
            displayVertex(0); // display it
            theQueue.insert(0); // insert at tail
            int v2;
 
            while (!theQueue.isEmpty()) // until queue empty,
            {
                int v1 = theQueue.remove(); // remove vertex at head
                // until it has no unvisited neighbors
                while ((v2 = getAdjUnvisitedVertex(v1)) != -1) { // get one,
                    vertexList[v2].wasVisited = true; // mark it
                    displayVertex(v2); // display it
                    theQueue.insert(v2); // insert it
                }
            }
            // queue is empty, so we're done
            for (int j = 0; j < nVerts; j++) {
				// reset flags
                vertexList[j].wasVisited = false;
			}
        }
 
        // returns an unvisited vertex adj to v
        public int getAdjUnvisitedVertex(int v) {
            for (int j = 0; j < nVerts; j++) {
				if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
					return j;
				}
			}
            return -1;
        }
    }
}
