package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Amazon2 {

    public static void main(String[] args) {
        List<List<Integer>> problems = new ArrayList<List<Integer>>();
        List<Integer> problem1 = new ArrayList<Integer>();
        problem1.add(1);
        problem1.add(8);
        List<Integer> problem2 = new ArrayList<Integer>();
        problem2.add(2);
        problem2.add(7);
        List<Integer> problem3 = new ArrayList<Integer>();
        problem3.add(3);
        problem3.add(14);
        problems.add(problem1);
        problems.add(problem2);
        problems.add(problem3);

        List<List<Integer>> returnProblems = new ArrayList<List<Integer>>();
        List<Integer> returnProblem1 = new ArrayList<Integer>();
        returnProblem1.add(1);
        returnProblem1.add(5);
        List<Integer> returnProblem2 = new ArrayList<Integer>();
        returnProblem2.add(2);
        returnProblem2.add(10);
        List<Integer> returnProblem3 = new ArrayList<Integer>();
        returnProblem3.add(3);
        returnProblem3.add(14);

        returnProblems.add(returnProblem1);
        returnProblems.add(returnProblem2);
        returnProblems.add(returnProblem3);

        List<List<Integer>> lists = optimalUtilization(20, problems, returnProblems);
        for (List<Integer> list : lists) {
            for (Integer num : list) {
                System.out.println(num);
            }
        }
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static List<List<Integer>> optimalUtilization(int maxTravelDist,
                                                  List<List<Integer>> forwardRouteList,
                                                  List<List<Integer>> returnRouteList) {
        // WRITE YOUR CODE HERE
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<RouteDistance> forwardRouteDistance = new ArrayList<RouteDistance>();
        List<RouteDistance> returnRouteDistance = new ArrayList<RouteDistance>();
        populate(forwardRouteList, forwardRouteDistance);
        Collections.sort(forwardRouteDistance);
        populate(returnRouteList, returnRouteDistance);
        Collections.sort(returnRouteDistance);

        int forwardCounter = 0;
        int returnCounter = 0;
        while (forwardCounter < forwardRouteDistance.size() && returnCounter < returnRouteDistance.size()) {
            RouteDistance currentForwardRouteDistance = forwardRouteDistance.get(forwardCounter);
            int currentForwardRoute = currentForwardRouteDistance.distance;

            RouteDistance currentReturnRouteDistance = returnRouteDistance.get(returnCounter);
            int currentReturnRoute = currentReturnRouteDistance.distance;

            if (currentForwardRoute + currentReturnRoute <= maxTravelDist) {
                List<Integer> combination = new ArrayList<Integer>();
                combination.add(currentForwardRouteDistance.id);
                combination.add(currentReturnRouteDistance.id);
                result.add(combination);
                forwardCounter++;
                returnCounter++;
            } else if (returnCounter + 1 < returnRouteDistance.size()) {
                returnCounter++;
            } else {
                forwardCounter++;
            }
        }
        return result;
    }

    public static void populate(List<List<Integer>> returnRouteList, List<RouteDistance> returnRouteDistance) {
        for (int i = 0; i < returnRouteList.size(); i++) {
            List<Integer> currentRoute = returnRouteList.get(i);
            returnRouteDistance.add(new RouteDistance(currentRoute.get(0), currentRoute.get(1)));
        }
    }

    static class RouteDistance implements Comparable<RouteDistance>{
        public Integer id;
        public Integer distance;

        public RouteDistance(Integer id, Integer distance){
            this.id = id;
            this.distance = distance;
        }

        public int compareTo(RouteDistance o) {
            return o.distance.compareTo(this.distance);
        }
    }
    // METHOD SIGNATURE ENDS
}
