package java_hw.week10.hmw;

public class ThreadSafeCounterSimulation {
    public static void main (String [] args){
        ThreadSafeCounter counter = new ThreadSafeCounter();

        Runnable addCounter = () -> {
            for (int i = 0; i < 1000; i++){
                counter.increment();
            }
        };

        Runnable decrementCounter = () -> {
            for (int i = 0; i < 1000; i++){
                counter.decrement();
            }
        };

        Thread t1 = new Thread(addCounter);
        Thread t2 = new Thread(decrementCounter);


        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Thread is interrupted.");
        }

        System.out.println("Final counter is: " + counter.getValue());

    }
}
