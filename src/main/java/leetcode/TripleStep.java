package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TripleStep {

    public int calculate(int steps){
       int [] memo = new int[steps + 1];
       Arrays.fill(memo, -1);
       return calculate(steps, memo);
    }

    private int calculate(int steps, int[] memo) {
        if(steps < 0){
            return 0;
        }
        else if (steps == 0){
            return 1;
        }
        else if (memo[steps] > -1){
            return memo[steps];
        }
        else{
            memo[steps] = calculate(steps - 1, memo) + calculate(steps - 2, memo) + calculate(steps - 3 , memo);
            return memo[steps];
        }
    }
}
