package advanced_dsa;

import java.util.*;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        
        // O (N log K)
        PriorityQueue<int[]> heap = 
            new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        
        HashMap<Integer, Integer> num2freq = new HashMap<>();
        for (int num: nums) {
            int freq = num2freq.getOrDefault(num, 0);
            num2freq.put(num, freq + 1);
        }
        
        for (Map.Entry entry: num2freq.entrySet()) {
            int key = (int)entry.getKey(), value = (int)entry.getValue();
            heap.add(new int[]{key, value});
            
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            int[] pair = heap.poll();
            res[i] = pair[0];
        }
        return res;
    }   
}
