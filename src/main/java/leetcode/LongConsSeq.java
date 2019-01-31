package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongConsSeq {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int longest = 0;

        for(int i = 0; i < nums.length; i++){
            int current = nums[i];
            longest = Math.max(getConsecutiveNumbers(current, set), longest);

            if(!set.contains(current)){
                set.add(current);
            }
        }

        return longest;

    }

    public int getConsecutiveNumbers(int number, Set set){
        boolean checkLeft = false;
        int left = number - 1;
        int right = number + 1;
        boolean checkRight = false;
        int total = 0;
        while(!checkLeft){
            if(!set.contains(left)){
                checkLeft = true;
            }
            else{
                left--;
                total++;
            }
        }

        while(!checkRight){
            if(!set.contains(right)){
                checkRight = true;
            }
            else{
                right++;
                total++;
            }
        }

        return total;
    }
}