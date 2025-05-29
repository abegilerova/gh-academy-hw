package basicSorting;

public class MaximumProductDifferenceBetweenTwoPairs {

    public static int maxProductDifference(int[] nums) {
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++){
            if(nums[i] > firstLargest){
                secondLargest = firstLargest;
                firstLargest = nums[i];
            } else if(nums[i] > secondLargest && nums[i] != firstLargest){
                secondLargest = nums[i];
            } else if(nums[i]  < firstSmallest){
                secondSmallest =firstSmallest;
                firstSmallest = nums[i];

            } else if(nums[i] < secondSmallest && nums[i] != firstSmallest){
                secondSmallest = nums[i];

            }
        }

        System.out.println(firstLargest);
        System.out.println(secondLargest);
        System.out.println(firstSmallest);
        System.out.println(secondSmallest);

        return firstLargest * secondLargest - firstSmallest * secondSmallest;


    }

    public static void main(String[] args) {
        int [] nums = {5,6,2,7,4};
        System.out.println(maxProductDifference(nums));
        //34

    }
}
