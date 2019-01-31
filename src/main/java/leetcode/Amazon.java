package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Amazon {

    public static void main(String[] args) {
        List<List<Integer>> problem = new ArrayList<List<Integer>>();
        List<Integer> problem1 = new ArrayList<Integer>();
        problem1.add(1);
        problem1.add(-3);
        problem.add(problem1);
       Solution solution = new Solution();
        List<List<Integer>> list = solution.nearestVegetarianRestaurant(3, problem, 1);
    }

    // CLASS BEGINS, THIS CLASS IS REQUIRED
    public static class Solution
    {
        public Solution(){

        }
        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
         public List<List<Integer>> nearestVegetarianRestaurant(int totalRestaurants,
                                                                List<List<Integer>> allLocations,
                                                                int numRestaurants)
        {
            // WRITE YOUR CODE HERE
            List<DistanceCoordinates> distances = new ArrayList<DistanceCoordinates>();
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            for(int i = 0; i < allLocations.size(); i++){
                List<Integer> coordinates = allLocations.get(i);
                    Double distance = calculate(coordinates.get(0), coordinates.get(1));
                    DistanceCoordinates distanceCoordinates = new DistanceCoordinates(coordinates, distance);
                    distances.add(distanceCoordinates);
                }

            Collections.sort(distances);

            for(int i = 0; i < numRestaurants; i++){
                DistanceCoordinates current = distances.get(i);
                result.add(current.coordinates);
            }

            return result;
        }

        public Double calculate(int xCoordinate, int yCoordinate){
            Double squared = Math.pow(xCoordinate, 2) + Math.pow(yCoordinate, 2);
            return Math.sqrt(squared);
        }
        // METHOD SIGNATURE ENDS


    }

    static class DistanceCoordinates implements Comparable<DistanceCoordinates>{

        public List<Integer> coordinates;
        public Double distance;

        DistanceCoordinates(List<Integer> coordinates, Double distance) {
            this.coordinates = coordinates;
            this.distance = distance;
        }

        public int compareTo(DistanceCoordinates o) {
            return this.distance.compareTo(o.distance);
        }
    }
}
