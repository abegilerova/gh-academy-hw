package arraysI;

import java.util.Arrays;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        k = k % nums.length  ;
        reverse(nums, 0, nums.length-1);
        reverse(nums,0, k-1 );
        reverse(nums, k, nums.length-1);
        System.out.println(Arrays.toString(nums));

    }

    public static void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        //            {7,6,5,4,3,2,1}
        //output =    [5,6,7,1,2,3,4]
        int k = 3;

        rotate(nums, k);

    }
}
