package heapsort;

import java.util.PriorityQueue;

public class KthLargestInArray {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        System.out.println(minHeap);

        return minHeap.peek();

    }

    public static void main(String[] args) {
        int [] nums = {3,2,1,5,6,4};
        int k = 2;
        findKthLargest(nums, k);

    }
}
