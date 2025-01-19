public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {

        String currentPrefix = strs[0];

        for (int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(currentPrefix) != 0){

                currentPrefix = currentPrefix.substring(0, currentPrefix.length() - 1);
                if(currentPrefix.isEmpty()){
                    return "";
                }
            }

        }
        System.out.println(currentPrefix);
        return currentPrefix;

    }

    public static void main(String[] args) {
        String [] strs =  {"flower","flow","flight"};
        longestCommonPrefix(strs);

    }
}
