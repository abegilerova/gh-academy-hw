import java.util.Arrays;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int left = 0;
        int right = nums.length -1;
        int copyK = k;

        while (left <= right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

        int nextLeft = 0;


        while (nextLeft <= k){
            int temp = nums[nextLeft];
            nums[nextLeft] = nums[k-1];
            nums[k -1] = temp;
            nextLeft++;
            k--;
        }


        int nextRight = nums.length - 1;
        while(copyK <= nextRight ){
            int temp = nums[copyK];
            nums[copyK] = nums[nextRight];
            nums[nextRight] = temp;
            copyK++;
            nextRight--;
        }

        System.out.println(Arrays.toString(nums));

    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        int k = 3;

        rotate(nums, k);

    }
}
