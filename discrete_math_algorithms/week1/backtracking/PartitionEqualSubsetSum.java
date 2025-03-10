package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {

        int sum = java.util.Arrays.stream(nums).sum();
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;

       return canBackTrack (nums, nums.length -1 , target);

    }

    public static boolean canBackTrack(int[] nums, int index, int target){
        if(target == 0){
            return true;
        }

        if (index < 0 || target < 0) {
            return false;
        }


        boolean include = canBackTrack(nums, index-1, target - nums[index]);
        boolean exclude = canBackTrack(nums, index -1, target);

        return include || exclude;
    }
    public static void main(String[] args) {
       int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
    }
}
