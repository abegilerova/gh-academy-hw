package recursion;

public class Pow {
    public static double myPow(double x, int n) {
        // Base case
        if (n == 0) return 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        // Recursive case
        double half = myPow(x, n / 2);

        // If n is even
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;  // If n is odd
        }
    }

    public static void main(String[] args) {
       double x = 2;
       int n = 3;

        System.out.println(myPow(x,n));
    }
}
