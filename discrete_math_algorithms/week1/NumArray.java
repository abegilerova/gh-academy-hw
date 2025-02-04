import java.util.Arrays;

class NumArray {

    int [] prefixSums;

    public NumArray(int[] nums) {
        this.prefixSums = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            prefixSums[i+1] = prefixSums[i] + nums[i];
        }
        System.out.println(Arrays.toString(prefixSums));
    }

    public int sumRange(int left, int right){
        return prefixSums[right + 1] - prefixSums[left];
    }

    public static void main(String[] args) {
        int [] nums = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(0,2);
        System.out.println(param_1);

    }
}

