package java_hw.week10.hmw;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

    private final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

    public void put (String key, String value){
        System.out.println(Thread.currentThread().getName() + " putting: " + key + " -> " + value);
        cache.put(key, value);
    }

    public String get(String key){
        String value = cache.get(key);
        System.out.println(Thread.currentThread().getName() + " returning key and value: " + key + " ->  " + (value != null ? value : "null") );
        return value;
    }
}
