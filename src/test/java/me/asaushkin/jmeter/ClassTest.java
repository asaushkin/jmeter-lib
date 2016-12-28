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
    
    @Test
    public void testConstructorPrivate() throws Exception {
        UtilityClass.assertUtilityClassWellDefined(Counter.class);
    }
}
