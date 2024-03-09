package search;
import java.util.*;

class HitCounter {
    
    List<Integer> q;
    /** Initialize your data structure here. */
    public HitCounter() {
        q = new ArrayList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        q.add(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        if (q.size() == 0) {
            return 0;
        }
        int index = binarySearch(q, timestamp);
        if (index == -1) {
            return 0;
        }
        return q.size() - index;
    }

    private int binarySearch(List<Integer> arr, int target) {
        int start = 0;
        int end = arr.size() - 1;

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (target - arr.get(mid) < 300) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (target - arr.get(start) < 300) {
            return start;
        }
        if (target - arr.get(end) < 300) {
            return end;
        }
        return -1;
    }
}


/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */