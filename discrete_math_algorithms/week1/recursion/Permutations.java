package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        if(nums.length == 1){
            Arrays.asList(nums);
        }

        return result;

    }

    public static void main(String[] args) {
       int[] nums = {1,2,3};
       permute(nums);
    }
}
