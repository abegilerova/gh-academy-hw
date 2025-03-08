package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backTrack(result, new StringBuilder(),0,0, n);
        System.out.println(result);
        return result;
    }

    public static void backTrack( List<String> result, StringBuilder combination, int openCount, int closeCount, int n) {

        //baseCase
        if (combination.length() == 2 * n) {
            result.add(combination.toString());
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (i == 0 && openCount < n) {
                combination.append("(");
                backTrack(result, combination, openCount + 1, closeCount, n);
                combination.deleteCharAt(combination.length() - 1);
            }

            if (i == 1 && closeCount < openCount) {
                combination.append(")");
                backTrack(result, combination, openCount, closeCount + 1, n);
                combination.deleteCharAt(combination.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        //output ["((()))","(()())","(())()","()(())","()()()"]
        generateParenthesis(n);


    }
}
