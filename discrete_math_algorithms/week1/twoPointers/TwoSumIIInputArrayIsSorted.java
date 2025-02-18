package twoPointers;

import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted {

    public static int[] twoSum(int[] numbers, int target) {

        int[] result = new int [2];

        int left = 0;
        int right = numbers.length-1;

        while( left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                result[0] = left +1;
                result[1] = right +1 ;
                return result;
            } else if(sum <  target){
                left++;
            } else {
                right--;
            }
        }
    System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        int [] numbers = {2,7,11,15};
        int target = 9;

        //System.out.println(Arrays.toString(twoSum(numbers, target)));
        twoSum(numbers, target);
    }
}
