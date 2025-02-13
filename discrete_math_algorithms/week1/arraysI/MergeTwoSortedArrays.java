package arraysI;

public class MergeTwoSortedArrays {
    public  static void merge(int[] nums1, int m, int[] nums2, int n) {
         int i = m - 1;
         int j = n - 1;
         int k = m + n - 1;

         while(j >= 0 && i >= 0){
             System.out.println("j " + j);
             System.out.println("i " + i);
             if(nums1[i] > nums2[j]   ){
                 nums1[k] = nums1[i];
                 i--;
             } else {
                 nums1[k] = nums2[j];
                 j--;
             }
             k--;

         }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }

    }
    public static void main(String[] args) {
        int [] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int [] nums2 = {2,5,6};
        int n = 3;

        merge(nums1, m, nums2, n);
    }
}
