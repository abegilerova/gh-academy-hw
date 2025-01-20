import java.util.Stack;

public class BackspaceStringCompare {

    public static boolean backspaceCompare(String s, String t) {
        return processString(s).equals(processString(t));
    }

    public static String processString(String str){

        Stack<Character> charStack = new Stack<>();

        for (char c : str.toCharArray()){
            if(c == '#'){
                if(!charStack.isEmpty()){
                    charStack.pop();
                }
            } else {
                charStack.push(c);
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!charStack.isEmpty()){
            builder.append(charStack.pop());
        }

        return builder.reverse().toString();
    }
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare(s,t));
    }
}
