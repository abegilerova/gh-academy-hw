import java.util.*;

public class GroupAnagrams {

    public  static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> finalResult = new ArrayList<>();
        Map<Integer,  String[]> grouping = new HashMap<>();
        int index = 0;

        for (int i = 0; i < strs.length; i++){
            for(int j = i+1; j <strs.length; j++) {
                if (isAnagram(strs[i], strs[j])) {

                    grouping.put(index, new String[]{strs[i] , strs[j]});
                }
                System.out.println(strs[i]);
            }

        }

        for (Map.Entry<Integer, String[]> entry : grouping.entrySet()) {
            Integer key = entry.getKey();
            String[] value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + Arrays.toString(value));
            List<String> innerList = new ArrayList<>(Arrays.asList(entry.getValue()));
            finalResult.add(innerList);
        }

        System.out.println(finalResult);

        return finalResult;

    }

    public static boolean isAnagram(String s1, String s2) {
        // Remove any whitespace and convert to lower case for case-insensitive comparison
        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();

        // If lengths differ, they cannot be anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Convert strings to char arrays
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        // Sort the character arrays
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        // Compare the sorted arrays
        return Arrays.equals(s1Array, s2Array);
    }

    public static void main(String[] args) {

        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strs);

    }
}
