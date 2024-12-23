import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {

        int j = 0;
        for (int i = 1; i < nums.length; i++){
//            System.out.println(nums[i]);
//            System.out.println(nums[j]);
            if(nums[i] != nums[j]){
                j++;
                System.out.println(i);
                System.out.println(j);
                nums[j] = nums[i];

            }
        }

        System.out.println(Arrays.toString(nums));
        return j +1;

    }

    public static void main(String[] args) {
        int [] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));


    }
}
