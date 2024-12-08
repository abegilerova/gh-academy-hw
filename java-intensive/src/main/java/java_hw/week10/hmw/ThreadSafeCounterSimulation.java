package java_hw.week10.hmw;

public class ThreadSafeCounterSimulation {
    public static void main (String [] args){
        ThreadSafeCounter counter = new ThreadSafeCounter();

        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++){
                counter.increment();
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++){
                counter.decrement();
            }
        });

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Thread is interrupted.");
        }

        System.out.println("Final counter is: " + counter.getValue());

    }
}
