import java.util.*;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {

        int [] finalResult = new int [k];
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

       //System.out.println(freqMap);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(freqMap::get));

        System.out.println(minHeap);
        for (int num : freqMap.keySet()){
            //System.out.println(num);
            minHeap.offer(num);
//            System.out.println(minHeap);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }

        System.out.println(minHeap);

        for(int i =0; i < k; i ++){
            finalResult[i] = minHeap.poll();
        }

       System.out.println(Arrays.toString(finalResult));

        return finalResult;
    }

    public static void main(String[] args) {
        int [] nums = {1,1,1,2,2,3};
        int k = 2;

        topKFrequent(nums, k);

    }
}
