package practicalExecises.week3;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public class Main {
        public static int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> indexByNumValue = new HashMap<>();
            //value by key
            //index by value
            for (int i = 0; i < nums.length; i++){
                int val = nums[i];
                int complement = target - val;
                if(indexByNumValue.containsKey(complement)){
                    return new int[]{indexByNumValue.get(complement),i};
                }
                indexByNumValue.put(val, i);
            }

            return new int[]{};
        }

        public static void main(String[] args) {
            //            0,1,2,3
            int[] nums = {5,8,3,9};
            int t  =12;
            int[] indices = twoSum(nums,t); // 0,1
            System.out.println("Indices: " + indices[0] + ", " + indices[1]);
            indices = twoSum(nums, 12); // 2,3
            System.out.println("Indices: " + indices[0] + ", " + indices[1]);
        }
    }
}
