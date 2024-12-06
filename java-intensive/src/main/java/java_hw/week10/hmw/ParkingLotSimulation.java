package java_hw.week10.hmw;

public class ParkingLotSimulation {
    public static void main(String [] args){
        ParkingLot pk = new ParkingLot(5);
        for (int i = 1; i <= 10; i++){
            String car = "car " + i;

            new Thread(() -> pk.enterParkingLot(car)).start();
        }
    }
}
