public class ReverseString {

    public static void reverseString(char[] str){
       int left = 0;
       int right = str.length - 1;

       while (left < right){
           char placeholder = str[left];
           str[left] = str[right];
           str[right] = placeholder;
           left++;
           right--;
       }

    }

    public static void main (String [] args){
        char [] s = {'h','e','l','l','o'};

        reverseString(s);

        System.out.println(s);

    }
}
