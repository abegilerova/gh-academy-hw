package binarySearch;

public class FirstBadVersion {
    private static int firstBad;

    public static boolean isBadVersion(int version){

        return version >= firstBad;
    }

    public  static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int ans = n;

        while (left <= right){
            int middle = left + (right - left) / 2;
            if(isBadVersion(middle)){
                ans = middle;
                right = middle-1;
            } else {
                left  = middle + 1;

            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int n1 = 5;
        firstBad = 4;
        int result = firstBadVersion(n1);
        System.out.println("First bad version is: " + result);
    }
}
