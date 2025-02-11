package binarySearch;

public class CapacityToShipPackagesWithinDDays {

    public static  int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;

        for (int weight : weights){
            left = Math.max(left, weight);
            right+=weight;
        }

        int ans = right;

        while (left <= right){
            int mid = left + (right - left) /2;

            if(canShip(weights, days, mid)){
             ans = mid;
             right = mid - 1;
            } else {
                left = mid +1;
            }
        }



        System.out.println(ans);

        return ans;

    }

    public static boolean canShip(int[] weights, int days, int capacity){
        int daysNeeded = 1;
        int currentLoad = 0;
        for (int weight : weights){
            if(currentLoad + weight > capacity){
                daysNeeded++;
                currentLoad =0;
            }
            currentLoad+=weight;
        }

        return daysNeeded <= days;
    }
    public static void main(String[] args) {
       int [] weights = {1,2,3,4,5,6,7,8,9,10};
       int days = 5;

       shipWithinDays(weights, days);
    }
}
