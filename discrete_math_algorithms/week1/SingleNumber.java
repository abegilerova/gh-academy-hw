public class SingleNumber {
    public static int findSingleNumber(int [] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++ ){
           result = (nums[i] ^ result);

        }

        return result;
    }
    public static void main(String[] args) {
        int[] myArray = {1, 1, 3, 3, 4};
        findSingleNumber(myArray);
    }
    }



