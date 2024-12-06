package java_hw.week10.hmw;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeCounter {
    private int counter = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment(){
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }


    public void decrement(){
        lock.lock();
        try {
            counter--;
        } finally {
            lock.unlock();
        }
    }

    public int getValue(){
        lock.lock();
       try{
           return counter;
       } finally {
           lock.unlock();
       }
    }


}
