package hashMap;

import java.util.*;

public class GroupAnagrams {

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
