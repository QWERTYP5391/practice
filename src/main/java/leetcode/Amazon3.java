package leetcode;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

import java.util.List;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Amazon3 {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
        // WRITE YOUR CODE HERE
        boolean[][] visited = new boolean[numRows][numColumns];
        return distanceHelper(0, 0, 0, lot, visited);
    }

    // METHOD SIGNATURE ENDS
    private int distanceHelper(int row, int column, int distance, List<List<Integer>> lot, boolean[][] visited) {

        if (lot.get(row).get(column).equals(9)) {
            return distance;
        }

        if (row + 1 < lot.size() && column < lot.get(0).size() && !lot.get(row + 1).get(column).equals(0) && !visited[row + 1][column]) {
            visited[row + 1][column] = true;
            return distanceHelper(row + 1, column, distance + 1, lot, visited);
        }

        if (row - 1 >= 0 && row - 1 < lot.size() && column < lot.get(0).size() && !lot.get(row - 1).get(column).equals(0) && !visited[row - 1][column]) {
            visited[row - 1][column] = true;
            return distanceHelper(row - 1, column, distance + 1, lot, visited);
        }

        if (row < lot.size() && column - 1 < lot.get(0).size() && !lot.get(row).get(column + 1).equals(0) && !visited[row][column + 1]) {
            visited[row][column + 1] = true;
            return distanceHelper(row, column + 1, distance + 1, lot, visited);
        }

        if (row < lot.size() && column - 1 >= 0 && column - 1 < lot.get(0).size() && !lot.get(row).get(column - 1).equals(0) && !visited[row][column - 1]) {
            visited[row][column - 1] = true;
            return distanceHelper(row, column - 1, distance + 1, lot, visited);
        }

        return 0;

    }
}


