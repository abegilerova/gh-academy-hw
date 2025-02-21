package twoPointers;

import java.util.Arrays;

public class StringCompression {
    public static int compress(char[] chars) {
      int read = 0;
      int write = 0;

      while (read < chars.length){

          char currentChar = chars[read];
          int count= 0;

          while (read < chars.length && chars[read] == currentChar ){
              read++;
              count++;
          }

          chars[write] = currentChar;
          write++;

          System.out.println(Integer.toString(count).toCharArray());
          if (count > 1) {
              for (char digit : Integer.toString(count).toCharArray()) {
                  chars[write] = digit;
                  write++;
              }
          }
      }

        //System.out.println(Arrays.toString(chars));
      return write  ;

    }

    public static void main(String[] args) {
        char [] chars = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));
    }
}
