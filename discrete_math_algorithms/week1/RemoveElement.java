import java.util.Arrays;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i ++){
            if(nums[i] != val){
                nums[k] = nums[i];
                System.out.println("nums " + Arrays.toString(nums) + "iteration " + i);
                k++;
            }
        }

        System.out.println("k " + k);
        return k;
    }
    public static void main(String[] args) {
        int nums [] = {3,2,2,3};
        removeElement(nums, 3);

    }
}
