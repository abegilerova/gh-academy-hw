public class ReverseBits {
    public static int reverseBits(int n) {
       int result = 0;
        for (int i = 0; i < 32; i++){
            //rightmost bit
            int bit = n & 1;
            result = (result << 1) | bit;
            n >>= 1;
        }



        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));

    }
}
