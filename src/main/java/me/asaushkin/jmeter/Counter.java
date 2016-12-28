package me.asaushkin.jmeter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.ToLongFunction;

/**
 * Any counters number may lay in this class. Use code in JSR232 Groovy 
 * preprocessor like that:
 * 
 * import me.asaushkin.jmeter.Counter
 * 
 * log.info("Current number: ${Counter.incrementAndGet("mycounter")}")
 * 
 * @author ags
 *
 */
public class Counter {
    
    private static ConcurrentHashMap<String, AtomicLong> cache = new ConcurrentHashMap<>();

    private Counter() {}
    
    private static synchronized long getCounterVal(String counter, ToLongFunction<AtomicLong> s) {
        cache.putIfAbsent(counter, new AtomicLong());

        return s.applyAsLong(cache.get(counter));
    }
    
    /**
     * Get counter value 
     * 
     * @param counter Counter name
     * @return counter value
     */
    public static long get(String counter) {
        return getCounterVal(counter, i -> i.get());
    }

    /**
     * Increment and get counter value
     * 
     * @param counter Counter name
     * @return incremented value of the counter
     */
    public static long incrementAndGet(String counter) {
        return getCounterVal(counter, i -> i.incrementAndGet());
    }
}
