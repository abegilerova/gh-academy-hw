package heapsort;

import java.util.PriorityQueue;

public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones ){
            maxHeap.add(stone);
        }

//        System.out.println(maxHeap);

        while(maxHeap.size() > 1 ) {
            int diff = maxHeap.poll() - maxHeap.poll();
            if (diff > 0) {
                maxHeap.add(diff);
            }
        }



        System.out.println(maxHeap.peek());
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();

    }

    public static void main(String[] args) {
        int [] input = {2,7,4,1,8,1};
        lastStoneWeight(input);
        //output 1
    }
}
