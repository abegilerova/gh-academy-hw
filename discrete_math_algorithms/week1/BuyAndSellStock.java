
class BuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int highestProfit = 0;

        for (int price : prices){
            if(price < minPrice){
                minPrice = price;
            }

            int profit = price - minPrice;
            if(profit > highestProfit){
                highestProfit = profit;
            }
        }
        System.out.println(highestProfit);
        return highestProfit;
    }

    public static void main(String[] args) {
        int[] numbers = {7,1,5,3,6,4};
        maxProfit(numbers);
    }
}