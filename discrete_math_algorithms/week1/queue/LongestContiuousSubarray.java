package queue;

import java.util.ArrayList;

public class LongestContiuousSubarray {
    public static int longestSubarray(int[] nums, int limit) {

        int maxValue = 0;

        for (int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++) {
                ArrayList<Integer> subArr = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    subArr.add(nums[k]);
                }

                System.out.println(subArr);
                boolean isValid = true;
                for (int z = 0; z < subArr.size(); z++) {
                    for (int x = z + 1; x < subArr.size(); x++) {
                        int diff = Math.abs(subArr.get(z) - subArr.get(x));
                        if (diff > limit) {
                            isValid = false;
                            break;
                        }
                    }

                    if (!isValid) break;
                }

                if(isValid){
                    maxValue = Math.max(maxValue, subArr.size());
                }
            }
        }
        System.out.println("maxValue: " + maxValue);
        return maxValue;
    }

    public static void main(String[] args) {
        int [] nums = {8,2,4,7};
        int limit = 4;
        longestSubarray(nums, limit);
    }
}
