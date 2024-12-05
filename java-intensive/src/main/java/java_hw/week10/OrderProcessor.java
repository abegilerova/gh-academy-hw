package java_hw.week10;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class OrderProcessor {
    private final BlockingQueue<String> orderQueue = new ArrayBlockingQueue<>(10);

    public void placeOrder(String order ){
        try{
            orderQueue.put(order);
            System.out.println("Order is placed " + order);

        } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
        }
    }

    public void processOrder(){
        try {
            while(true){
                String order = orderQueue.take();
                System.out.println("Processing order " + order);
                Thread.sleep(1000); //Simulate processing time
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
