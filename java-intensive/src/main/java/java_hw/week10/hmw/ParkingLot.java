package java_hw.week10.hmw;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

public class ParkingLot {
    private final Semaphore spots;

    public ParkingLot(int spots){
        this.spots = new Semaphore(spots);
    }

    public void enterParkingLot(String car){
        try{
            System.out.println("Car is waiting for a spot " );
            spots.acquire();
            System.out.println(car + " got a spot");
            Thread.sleep(2000);

        }catch(InterruptedException e){
            Thread.currentThread().interrupt();

        }finally {
            spots.release();
            System.out.println(car + " left a parking lot");

        }
    }


}
