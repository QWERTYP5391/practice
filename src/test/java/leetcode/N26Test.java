package leetcode;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class N26Test {

    private N26 testObj = new N26();

    @Test
    public void findFirstUniqueCharacter() {
        Character element = testObj.findFirstUniqueCharacter("element");
        assertThat(element, equalTo('l'));
    }
}