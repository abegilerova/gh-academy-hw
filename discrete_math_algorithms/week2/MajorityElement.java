
class MajorityElement {
    public static int findMajorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums){
            if (count == 0){
                candidate = num;
            }

            if (num == candidate){
                count += 1;
            } else {
                count -= 1;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int [] nums = {3,2,3};
        System.out.println(findMajorityElement(nums));
    }
}