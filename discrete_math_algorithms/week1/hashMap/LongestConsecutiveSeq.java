package hashMap;

import java.util.*;

public class LongestConsecutiveSeq {
    public static int longestConsecutive(int[] nums) {

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums){
            numSet.add(num);
        }

        int longest = 0;

        for (int num : numSet){
            System.out.println("num " + num);
            if(!numSet.contains(num -1)){
                int currentNum = num;
                int currentStreak = 1;

                while(numSet.contains(currentNum + 1)){
                    currentNum++;
                    currentStreak++;

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

    public static class GroupAnagrams {

        public  static List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> finalMap = new HashMap<>();

            for (String str : strs){
                char [] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String sortedStr = new String(charArray);
                if(!finalMap.containsKey(sortedStr)){
                    finalMap.put(sortedStr, new ArrayList<>());
                    System.out.println(finalMap);
                }

                finalMap.get(sortedStr).add(str);
                System.out.println(finalMap);
            }

            return new ArrayList<>(finalMap.values());

        }

        public static void main(String[] args) {

            String [] strs = {"eat","tea","tan","ate","nat","bat"};
            groupAnagrams(strs);

        }
    }
}
