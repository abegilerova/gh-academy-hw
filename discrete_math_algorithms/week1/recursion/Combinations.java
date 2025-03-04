package recursion;
import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(1, n, k, new ArrayList<>(), result);
        System.out.println(result);
        return result;
    }

    public static void backTrack(int start,int n, int k, List<Integer> combination, List<List<Integer>> result ){
        //base case
        if(combination.size() == k){
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= n; i++){
            combination.add(i);
            backTrack(i+1, n, k, combination, result); //recur with next number
            combination.remove(combination.size() - 1); //backtrack undo choice
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Combinations solution = new Combinations();
        List<List<Integer>> combinations = solution.combine(4, 2);

    }
}
