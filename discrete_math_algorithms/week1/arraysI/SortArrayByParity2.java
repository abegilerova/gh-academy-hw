package arraysI;

import java.util.Arrays;

public class SortArrayByParity2 {
    public static int[] sortArrayByParityII(int[] nums) {
        int evenIndex = 0;
        int oddIndex = 1;


        while(evenIndex < nums.length && oddIndex < nums.length){
            while (evenIndex < nums.length && nums[evenIndex] % 2 == 0){
                evenIndex+=2;
            }

            while (oddIndex < nums.length && nums[oddIndex] % 2 != 0){
                oddIndex +=2;
            }

            if(oddIndex < nums.length && evenIndex < nums.length){
                int temp = nums[evenIndex];
                nums[evenIndex] = nums[oddIndex];
                nums[oddIndex] = temp;
            }



//            System.out.println(evenIndex);

        }

       System.out.println(Arrays.toString(nums));
        return nums;
    }
    public static void main(String[] args) {
        int [] nums = {4,2,5,7};
                    //[4,5,2,7]
        sortArrayByParityII(nums);

    }
}
