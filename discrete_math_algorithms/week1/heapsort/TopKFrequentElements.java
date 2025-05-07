package heapsort;

import java.util.*;

public class TopKFrequentElements {

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> freq = new HashMap<>();

        for (String word : words){

            freq.put(word,freq.getOrDefault(word, 0) +1 );
        }

        //minHeap , priorityQueue
        PriorityQueue<String> heap = new PriorityQueue<>((word1, word2) -> {
            System.out.println("word1 " + word1);
            System.out.println("word2 " + word2);
            int freq1 = freq.get(word1);
            int freq2 = freq.get(word2);

            // Compare by frequency (lower frequency comes first)
            if (freq1 != freq2) {
                return freq1 - freq2;  // lower freq = higher priority in min-heap
            }

            // If frequencies are equal, compare by reverse alphabetical order
            return word2.compareTo(word1); // so lexicographically smaller word comes later
        });

        for(String word : freq.keySet()){
            heap.offer(word);
            System.out.println("heap " + heap);
            if(heap.size() > k){
                heap.poll();
            }
        }

        while(!heap.isEmpty()){
            result.add(heap.poll());
        }

        System.out.println(result);
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        String [] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        topKFrequent(words,k);
    }
}
