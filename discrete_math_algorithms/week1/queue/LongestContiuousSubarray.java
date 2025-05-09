package queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LongestContiuousSubarray {
    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            // Maintain decreasing maxDeque
            while (!maxDeque.isEmpty() && nums[right] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(nums[right]);
            // Maintain increasing minDeque
            while (!minDeque.isEmpty() && nums[right] < minDeque.peekLast()) {
                minDeque.pollLast();
            }
            minDeque.addLast(nums[right]);


            //System.out.println(maxDeque);
            System.out.println(minDeque);

            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (nums[left] == maxDeque.peekFirst()) maxDeque.pollFirst();
                if (nums[left] == minDeque.peekFirst()) minDeque.pollFirst();
                left++; // shrink the window
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

//        System.out.println(maxLength);
        return maxLength;
    }




    public static void main(String[] args) {
        int [] nums = {8,2,4,7};
        int limit = 4;
        longestSubarray(nums, limit);
    }
}
