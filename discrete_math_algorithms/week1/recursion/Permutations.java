package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums,0, new ArrayList<>(), result );

        System.out.println(result);

        return result;

    }

    public static void backtrack(int [] nums, int start, List<Integer> combination,  List<List<Integer>> result){
        if(combination.size() == nums.length){
            result.add(combination);
            return;
        }

        for (int i = start; i < nums.length; i++){
            combination.add(nums[i]);
            backtrack(nums, start + 1, combination, result);
            combination.remove(combination.size()-1);
        }

    }

    public static void main(String[] args) {
       int[] nums = {1,2,3};
       permute(nums);
    }
}
