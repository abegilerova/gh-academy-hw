package stack;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();

        for (char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                charStack.push(c);

            }else if(c == ')' || c == ']' || c == '}'){
                if(charStack.isEmpty()){
                    return false;
                }

                char top = charStack.pop();
                System.out.println("top " + top);
                System.out.println("c " + c);
                if((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')){
                    return false;
                }

            }

        }



        return charStack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));

    }
}
