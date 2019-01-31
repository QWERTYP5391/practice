import leetcode.OneAway;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class OneAwayTest {


    @Test
    public void testOne() {
        String str1 = "pale";
        String str2 = "ple";
        assertTrue(OneAway.check(str1, str2));
    }

    @Test
    public void testTwo() {
        String str1 = "pales";
        String str2 = "pale";
        assertTrue(OneAway.check(str1, str2));
    }

    @Test
    public void testThree() {
        String str1 = "pale";
        String str2 = "bale";
        assertTrue(OneAway.check(str1, str2));
    }

    @Test
    public void testFour() {
        String str1 = "pale";
        String str2 = "bake";
        assertFalse(OneAway.check(str1, str2));
    }

    @Test
    public void testFive() {
        String str1 = "pale";
        String str2 = "pake";
        assertTrue(OneAway.check(str1, str2));
    }

    @Test
    public void testSix() {
        String str1 = "pale";
        String str2 = "pakes";
        assertFalse(OneAway.check(str1, str2));
    }
}