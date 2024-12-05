package java_hw.week10;

import java.util.concurrent.Semaphore;

public class Restaurant {
    private final Semaphore seats;

    public Restaurant(int seatCount){
        this.seats = new Semaphore(seatCount);
    }

    public void enterRestaurant(String customer){
        try{
            System.out.println(customer + " is waiting for a seat... ");
            seats.acquire(); //Wait for an available seat
            System.out.println(customer + " got a seat");
            Thread.sleep(2000); //simulate eating

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            seats.release(); //release the seat
            System.out.println(customer + " left the restaurant");
        }
    }
}
