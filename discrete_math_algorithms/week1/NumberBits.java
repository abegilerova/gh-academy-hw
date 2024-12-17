public class NumberBits {
    public static boolean isRightBitSet(int n) {
        return (n & 1) == 1;
    }

    public static int shiftRight(int n) {
        return n >> 1;
    }

    public static int calculateNumberBits(int n) {
        int counter = 0;

        while (n != 0){
            System.out.println("n "  + n);

            if (isRightBitSet(n)){
                counter++;
            }

            n = shiftRight(n);
            System.out.println(n);
        }

        return counter;
    }
    public static void main(String[] args) {
     calculateNumberBits(5);
    }


}
