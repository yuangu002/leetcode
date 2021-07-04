import java.util.*;

class LRUCache {
    Map<Integer, int[]> cache;
    int limit;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        limit = capacity;
    }
    
    public int get(int key) {
        
        if (!cache.containsKey(key)) {
            return -1;
        }
        int[] cb = cache.get(key);
        cache.remove(key);
        cache.put(key, cb);
        return cb[1];
    }
    
    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            int[] new_cb = new int[]{key, value};
            cache.put(key, new_cb);
        } else {
            // update
            int[] cb = cache.get(key);
            cb[1] = value;
            cache.remove(key);
            cache.put(key, cb);
        }
        
        if (cache.size() > limit) {
            int lru_cache = (int)cache.keySet().iterator().next();
            cache.remove(lru_cache);
        }
    }
}
