package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, new ArrayList<>(), result);
        System.out.println(result);
        return result;

    }

    public static void backtrack(int [] nums, int index, List<Integer> combination, List<List<Integer>> result){

        System.out.println("comb size " + combination.size());
        result.add(new ArrayList<>(combination));

        for (int i = index; i < nums.length; i++){
            combination.add(nums[i]);
            backtrack(nums, i+ 1,combination, result);
            combination.remove(combination.size()-1);
        }


    }

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        subsets(nums);

    }
}
