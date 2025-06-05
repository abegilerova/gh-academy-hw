package On2NSortingAlgos;

import java.util.Arrays;

public class MaximumIceCreamBars {
    public static int maxIceCream(int[] costs, int coins) {
        int result = 0;

        int maxInt = Integer.MIN_VALUE;

        for (int cost : costs){
            if(cost > maxInt ){
                maxInt = cost;
            }
        }

        int [] countedSort = new int [maxInt+1];

        for (int i = 0; i < costs.length; i++){
            countedSort[costs[i]]++;
        }

        for (int i = 0; i < countedSort.length; i++){
            System.out.println(countedSort[i]);
            while(countedSort[i] > 0 && coins >= i){
                result++;
                coins-=i;
                countedSort[i]--;
            }

        }


        System.out.println("result " + result);
        return result;



    }

    public static void main(String[] args) {
        int [] costs = {1,3,2,4,1};
        int coins = 7;
        maxIceCream(costs, coins);
        //output 4
    }
}
