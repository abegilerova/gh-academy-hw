//package stack;
//
//import static java.lang.Character.isDigit;
//
//public class DecodeString {
//    public static String decodeString(String s) {
//        StringBuilder sb = new StringBuilder();
//
//
//        for (char c : s.toCharArray()){
//            if(isDigit(c)){
//                sb.append(c);
//            }
//        }
//
//    }
//
//    public static void main(String[] args) {
//        String s = "3[a]2[bc]";
//        decodeString(s);
//        //Output: "aaabcbc"
//    }
//}
