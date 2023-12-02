package heap;
import java.util.*;

class MedianFinder {
    
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }
    // [1,5,6,8,9,10]
    // [1,5,6] max
    // [8,9,10] min
    
    // [1,5,6,9,10]
    // [1,5,6]
    // [9,10]
    
    public void addNum(int num) {
        if (minHeap.size() > 0 && minHeap.peek() < num) {
            minHeap.offer(num);
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        } else {
            maxHeap.offer(num);
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (Double.valueOf(maxHeap.peek()) + Double.valueOf(minHeap.peek())) / 2.0;
        } else {
            return Double.valueOf(maxHeap.peek());
        }
    }
}