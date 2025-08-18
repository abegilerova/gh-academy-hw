public class NumberPalindrome {
    public static boolean isPalindrome(int x) {
        int reversed = 0;

        while(x > reversed ){
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            System.out.println("reversed " + reversed);
            x = x / 10;
            System.out.println("x  " + x);
        }

        return x == reversed || x == reversed / 10;
    }

    public static void main(String[] args) {

        System.out.println( isPalindrome(121));
    }
}
