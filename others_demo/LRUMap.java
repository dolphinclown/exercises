
package demo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by CLAY on 2017/7/1.
 */
public class LRUMap<K, V> {
    private static Map<K, V> maps = new HashMap<K, V>();
    private static LinkedList<K> keys = new LinkedList<K>();
    private static int limit;  //缓存块大小

    public LRUMap(limit) {
        this.limit = limit;
    }

    public synchronized void put(K key, V value){
        if(keys.size() >= limit){
            maps.remove(keys.get(0));
            keys.remove();
        }
        maps.put(key, value);
        if(keys.contains(key)){
            keys.remove(key);
        }
        keys.add(key);
    }

    public synchronized V get(K key){
        if (keys.contains(key)) {
            keys.remove(key);
            keys.add(key);
        }
        return maps.get(key);
    }
}
