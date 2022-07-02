
import Cashe.LRUCache;
import org.junit.Test;

import static org.junit.Assert.*;

public class CacheTesting {
    @Test
    public void casheTest(){
        LRUCache<Integer, String[]> cache = new LRUCache<>(2);
        cache.put(1, new String[]{"123","1234","12345"});
        cache.put(2, new String[]{"1234","1232","1231"});
        cache.put(3, new String[]{"1234","1232","1231"});
        assertEquals("1232",cache.get(2)[1]);
        assertNull(cache.get(1));
    }
}
