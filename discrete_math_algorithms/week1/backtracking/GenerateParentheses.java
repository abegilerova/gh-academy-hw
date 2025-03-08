package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(0, n, result);
        System.out.println(result);
        return result;
    }

    public static void backTrack(int start,int n, List<String> result){

        String combination = "";
        //baseCase
        if(combination.length() == 2 * n){
            result.add(combination);
            return;

        }




    }

    public static void main(String[] args) {
        int n = 3;
        //output ["((()))","(()())","(())()","()(())","()()()"]
        generateParenthesis(n);


    }
}
