package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class Amazon3Test {

    @Test
    public void removeObstacle() {
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(1);
        one.add(1);
        one.add(1);
        input.add(one);

        List<Integer> two = new ArrayList<>();
        two.add(0);
        two.add(1);
        two.add(1);
        two.add(1);
        input.add(two);

        List<Integer> three = new ArrayList<>();
        three.add(0);
        three.add(1);
        three.add(0);
        three.add(1);
        input.add(three);

        List<Integer> four = new ArrayList<>();
        four.add(1);
        four.add(1);
        four.add(9);
        four.add(1);
        input.add(four);

        List<Integer> five = new ArrayList<>();
        five.add(0);
        five.add(0);
        five.add(1);
        five.add(1);
        input.add(five);



        assertThat(new Amazon3().removeObstacle(input.size(), input.get(0).size(), input), equalTo(5));
    }
}