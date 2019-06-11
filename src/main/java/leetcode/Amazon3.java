package leetcode;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Amazon3 {

    private static final int OBSTACLE = 9;

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
        // WRITE YOUR CODE HERE
        boolean[][] visited = new boolean[numRows][numColumns];
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, lot.get(0).get(0), 0));
        return distanceHelper(lot, queue, visited);
    }

    // METHOD SIGNATURE ENDS
    private int distanceHelper(List<List<Integer>> lot, Queue<Node> queue, boolean[][] visited) {
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (lot.get(node.row).get(node.column).equals(OBSTACLE)) {
                return node.distance;
            }
            List<Node> directions = getDirections(node, lot, visited, node.distance);
            queue.addAll(directions);
        }

        return 0;

    }

    private List<Node> getDirections(Node node, List<List<Integer>> lot, boolean[][] visited, int distance) {
        List<Node> directions = new ArrayList<>();

        if (node.row + 1 < lot.size() && node.column < lot.get(0).size() && !lot.get(node.row + 1).get(node.column).equals(0) && !visited[node.row + 1][node.column]) {
            visited[node.row + 1][node.column] = true;
            directions.add(new Node(node.row + 1, node.column, lot.get(node.row + 1).get(node.column), distance + 1));
        }

        if (node.row - 1 >= 0 && node.row - 1 < lot.size() && node.column < lot.get(0).size() && !lot.get(node.row - 1).get(node.column).equals(0) && !visited[node.row - 1][node.column]) {
            visited[node.row - 1][node.column] = true;
            directions.add(new Node(node.row - 1, node.column, lot.get(node.row - 1).get(node.column), distance + 1));
        }

        if ((node.row < lot.size() && node.column + 1 < lot.get(0).size()) && (node.value != 0 && !visited[node.row][node.column + 1])) {
            visited[node.row][node.column + 1] = true;
            directions.add(new Node(node.row, node.column + 1, lot.get(node.row).get(node.column + 1), distance + 1));
        }

        if (node.row < lot.size() - 1 && node.column - 1 >= 0 && node.column - 1 < lot.get(0).size() && !lot.get(node.row).get(node.column - 1).equals(0) && !visited[node.row][node.column - 1]) {
            visited[node.row][node.column - 1] = true;
            directions.add(new Node(node.row, node.column - 1, lot.get(node.row).get(node.column - 1), distance + 1));
        }

        return directions;

    }

    class Node {
        int row;
        int column;
        int value;
        int distance;

        Node(int row, int column, int value, int distance) {
            this.row = row;
            this.column = column;
            this.value = value;
            this.distance = distance;
        }
    }
}

