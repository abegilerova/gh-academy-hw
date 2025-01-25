import java.util.Arrays;

public class SquaresOfSortedArray {
    public static int[] sortedSquares(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int [] result = new int [nums.length];
        int index = nums.length-1;


       while (left <= right){
           int leftSquare = nums[left] * nums[left];
           int rightSquare = nums[right] * nums[right];

           if(leftSquare < rightSquare){
               result[index] = leftSquare;
               right--;
           } else {
               result[index] = rightSquare;
               left++;

           }

           index--;
        }

        System.out.println(Arrays.toString(result));
       return result;
    }

    public static void main(String[] args) {
        int [] nums = {-4,-1,0,3,10};
        sortedSquares(nums);

    }
}
