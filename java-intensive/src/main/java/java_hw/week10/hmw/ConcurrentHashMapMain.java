package java_hw.week10.hmw;

import javax.swing.plaf.TableHeaderUI;

public class ConcurrentHashMapMain {
    public static void main (String [] args){
        ConcurrentHashMapExample  cache = new ConcurrentHashMapExample();

        Runnable writer = () -> {
            for (int i = 0; i < 5; i++){
                String key = "Key " + i;
                String value = "Value " + i;
                cache.put(key, value);
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable reader = () -> {
            for (int i = 0; i < 5; i++){
                String key = "Key " + i;
                cache.get(key);
                try{
                    Thread.sleep(50);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread t1 = new Thread(writer);
        Thread t2 = new Thread(writer);
        Thread t3 = new Thread(reader);
        Thread t4 = new Thread(reader);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

        System.out.println("Cache operation completed");

    }
}
