package hashMap;

import java.util.*;

public class LongestConsecutiveSeq {
    public static int longestConsecutive(int[] nums) {

       Set<Integer> numSet = new HashSet<>();

       for(int num : nums){
           numSet.add(num);
       }

       int longest = 0;

       for (int num : numSet){

           if(!numSet.contains(num-1)) {
               int currentNum = num;
               int currentStreak = 1;

               while (numSet.contains(currentNum + 1)) {
                   currentStreak++;
                   currentNum++;
               }

               longest = Math.max(longest, currentStreak);
           }
       }

        System.out.println(longest);
       return longest;
    }

    public static void main(String[] args) {
        int [] nums =  {100,4,200,1,3,2};
        longestConsecutive(nums);

    }
}
