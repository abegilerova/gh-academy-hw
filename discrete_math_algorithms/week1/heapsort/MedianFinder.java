package heapsort;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder(){
        minHeap= new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b-a );

    }

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }

        System.out.println("maxHeap " + maxHeap);
        System.out.println("minHeap " + minHeap);
    }

    public double findMedian() {
        double result = 0;
        if(minHeap.size() == maxHeap.size()){
            result = (minHeap.peek() + maxHeap.peek()) /2.0;
        } else {
            result = maxHeap.peek();
        }

        System.out.println("result " + result);
        return result;

    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(5);
        obj.addNum(2);
        double param_2 = obj.findMedian();
    }
}
