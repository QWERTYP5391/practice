import leetcode.MyStack;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;


public class MyStackTest {

    MyStack<Integer> myStack;

    @Before
    public void setUp() throws Exception {
        myStack = new MyStack<Integer>();
    }

    @Test
    public void push() throws Exception {
        myStack.push(10);
        myStack.push(20);
        int expected = 20;
        assertThat(expected, equalTo(myStack.pop()));
        expected = 10;
        assertThat(expected, equalTo(myStack.pop()));
    }

    @Test
    public void pop() throws Exception {
    }
}