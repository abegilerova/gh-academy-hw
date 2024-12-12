import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public static int maxProfit(int[] prices) {
        List<Integer> pricesList = Arrays.stream(prices).boxed().collect(Collectors.toList());
        int min = Arrays.stream(prices).min().getAsInt();
        int minIndex = pricesList.indexOf(min);
        if(minIndex == pricesList.size()-1){
            return 0;
        }
        List <Integer> newPricesList = pricesList.subList(minIndex + 1, pricesList.size()-1);
        int maxNumber = (int) Collections.max(newPricesList);
        System.out.println("maxNumber - min " + (maxNumber - min));
        return maxNumber - min;

    }

    public static void main(String[] args) {
        int[] numbers = {7,6,4,3,1};
        maxProfit(numbers);
    }
}