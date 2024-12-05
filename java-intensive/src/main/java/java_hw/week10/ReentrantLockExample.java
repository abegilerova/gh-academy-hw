package java_hw.week10;

public class ReentrantLockExample {
    public static void main (String [] args){
        Inventory inventory = new Inventory();

        Runnable addTask = () -> inventory.addStock(10);
        Runnable removeTask = () -> inventory.removeStock(5);

        Thread thread1 = new Thread(addTask);
        Thread thread2 = new Thread(removeTask);
        Thread thread3 = new Thread(removeTask);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
