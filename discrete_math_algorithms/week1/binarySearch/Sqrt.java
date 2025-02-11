package binarySearch;

public class Sqrt {

    public static int mySqrt(int x) {

//        if(x < 2){
//            return x;
//        }

        int left = 1;
        int right = x/2;
        int ans = 0;



        while (left <= right){
            int mid = left + (right - left) / 2;

            long square = (long) mid * mid;
            if(square == x){
              return mid;
            } else if( square < x){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }

        System.out.println(ans);

        System.out.println("Aika");
        return ans;

    }

    public static void main(String[] args) {
        int n = 4;
        mySqrt(n);
    }

}
