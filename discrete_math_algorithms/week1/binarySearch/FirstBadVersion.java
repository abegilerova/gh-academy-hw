package binarySearch;

public class FirstBadVersion {
    private static int firstBad;

    public static boolean isBadVersion(int version){
        return firstBad >= version;
    }

    public  static int firstBadVersion(int n) {

        int left = 1;
        int right = n;

        while (left < right){
            int middle = (right + left )/2;
            if(isBadVersion(middle)){
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int n1 = 5;
        firstBad = 4;
        int result = firstBadVersion(n1);
        System.out.println("First bad version is: " + result);
    }
}
