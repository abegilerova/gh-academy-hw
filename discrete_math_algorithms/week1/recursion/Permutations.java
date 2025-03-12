package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);

        return result;
    }

    public static void backtrack(int[] nums, List<Integer> combination, boolean[] used, List<List<Integer>> result) {
        // Print the current combination at the start of the recursive call
        System.out.println("Current combination: " + combination);

        if (combination.size() == nums.length) {
            // When we find a valid permutation, print it before adding it to the result
            System.out.println("Found permutation: " + combination);
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;  // Skip used elements
            }

            // Print the decision to include the current element
            System.out.println("Choosing " + nums[i] + " at index " + i);

            combination.add(nums[i]);  // Add the element to the combination
            used[i] = true;            // Mark this element as used

            // Recursive call to build the next level of the combination
            backtrack(nums, combination, used, result);

            // After backtracking, print the state of the combination
            System.out.println("Backtracking, removing " + nums[i] + " from combination");

            combination.remove(combination.size() - 1);  // Remove the last element (backtrack)
            used[i] = false;  // Mark this element as unused for the next round
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permute(nums);
    }
}
