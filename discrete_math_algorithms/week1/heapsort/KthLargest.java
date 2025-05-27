package heapsort;

import java.util.PriorityQueue;

public class KthLargest {

    public PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;

        for(int num : nums){
            add(num);
        }

    }

    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();

    }

    // Optional main to test
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));  // returns 4
        System.out.println(kthLargest.add(5));  // returns 5
        System.out.println(kthLargest.add(10)); // returns 5
        System.out.println(kthLargest.add(9));  // returns 8
        System.out.println(kthLargest.add(4));  // returns 8
    }
}
