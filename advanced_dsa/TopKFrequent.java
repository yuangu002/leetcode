package advanced_dsa;

import java.util.*;
import javafx.util.Pair;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        
        // O (N log K)
        PriorityQueue<Pair<Integer, Integer>> heap = 
            new PriorityQueue<Pair<Integer, Integer>>((a, b) -> a.getValue() - b.getValue());
        
        HashMap<Integer, Integer> num2freq = new HashMap<>();
        for (int num: nums) {
            int freq = num2freq.getOrDefault(num, 0);
            num2freq.put(num, freq + 1);
        }
        
        for (Map.Entry entry: num2freq.entrySet()) {
            int key = (int)entry.getKey(), value = (int)entry.getValue();
            heap.add(new Pair(key, value));
            
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            Pair pair = heap.poll();
            res[i] = (int) pair.getKey();
        }
        return res;
    }   
}
