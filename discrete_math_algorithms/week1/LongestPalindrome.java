import java.util.Arrays;

public class LongestPalindrome {

    public static int longestPalindrome(String s) {
         int result  = 0;
         char [] charArray = s.toCharArray();
         int [] freq = new int [128];

         for (char c : charArray){
             freq[c]++;
         }

        System.out.println(Arrays.toString(freq));

         boolean hasOdd = false;
         for (int i = 0; i < freq.length; i++){
            if( freq[i] % 2 == 0){
                result += freq[i];
            } else {
                hasOdd = true;
                result += freq[i] -1;
            }
         }

         if(hasOdd){
             result++;
         }

        System.out.println(result);

         return result ;

    }

    public static void main(String[] args) {
        String s = "Abccccdd";
        System.out.println(longestPalindrome(s));


    }
}
