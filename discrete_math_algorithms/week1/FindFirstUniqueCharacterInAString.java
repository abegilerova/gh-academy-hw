import java.util.Arrays;

public class FindFirstUniqueCharacterInAString {

    public static int findFirstUniqueChar (String s){
//        for (int i = 0; i < s.length(); i++){
//            char c = s.charAt(i);
//
//            if (s.indexOf(c) == s.lastIndexOf(c)){
//                return i;
//            }
//        }
//
//        return - 1;

        int freq [] = new int [26];
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            freq[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++){
           char c = s.charAt(i);

           if(freq[c - 'a'] == 1){
               return i;
           }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(findFirstUniqueChar(s));

    }
}
