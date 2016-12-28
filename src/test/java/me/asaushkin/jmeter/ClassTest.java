package me.asaushkin.jmeter;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClassTest {
    @Test
    public void checkNonExistsCounter() throws Exception {
        assertEquals(0L, Counter.get("checkNonExistsCounter"));
    }
    
    @Test
    public void checkIncrement() throws Exception {
        Counter.get("checkIncrement");
        assertEquals(1L, Counter.incrementAndGet("checkIncrement"));
    }
    
    @Test(expected=IllegalAccessException.class)
    public void testConstructorPrivate() throws Exception {
        Counter.class.newInstance();
        fail("Utility class constructor should be private");
    }
    
}
