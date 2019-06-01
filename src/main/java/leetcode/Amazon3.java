package leetcode;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Amazon3 {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
        // WRITE YOUR CODE HERE
        boolean[][] visited = new boolean[numRows][numColumns];
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0));
        return distanceHelper(0, lot, visited, queue);
    }

    // METHOD SIGNATURE ENDS
    int distanceHelper(int distance, List<List<Integer>> lot, boolean[][] visited, Queue<Node> queue) {

        Node node = queue.remove();

        if (lot.get(node.row).get(node.column).equals(9)) {
            return distance;
        }

        if ((node.row + 1 >= 0 && node.row + 1 < lot.size()) && (node.column >= 0 && node.column < lot.get(0).size()) && !lot.get(node.row + 1).get(node.column).equals(0) && (!visited[node.row + 1][node.column])) {
            visited[node.row + 1][node.column] = true;
            queue.add(new Node(node.row + 1, node.column));
            return distanceHelper(distance + 1, lot, visited, queue);
        }

        if ((node.row - 1 >= 0 && node.row - 1 < lot.size()) && node.column >= 0 && node.column < lot.get(0).size() && !lot.get(node.row - 1).get(node.column).equals(0) && (!visited[node.row - 1][node.column])) {
            visited[node.row - 1][node.column] = true;
            queue.add(new Node(node.row - 1, node.column));
            return distanceHelper(distance + 1, lot, visited, queue);
        }

        if ((node.row >= 0 && node.row < lot.size()) && node.column + 1 >= 0 && node.column - 1 < lot.get(0).size() && !lot.get(node.row).get(node.column + 1).equals(0) && (!visited[node.row][node.column + 1])) {
            visited[node.row][node.column + 1] = true;
            queue.add(new Node(node.row, node.column + 1));
            return distanceHelper(distance + 1, lot, visited, queue);
        }

        if ((node.row >= 0 && node.row < lot.size()) && node.column - 1 >= 0 && node.column - 1 < lot.get(0).size() && !lot.get(node.row).get(node.column - 1).equals(0) && (!visited[node.row][node.column - 1])) {
            visited[node.row][node.column - 1] = true;
            queue.add(new Node(node.row, node.column - 1));
            return distanceHelper(distance + 1, lot, visited, queue);
        }

        return 0;

    }
}

class Node {
    public Node(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int row;
    public int column;


}
