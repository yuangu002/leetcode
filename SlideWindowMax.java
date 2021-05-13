import java.util.*;

public class SlideWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            push(dq, i, nums);
            if (i - k + 1 >= 0) {
                res[i-k+1] = nums[dq.peekFirst()];
                if (i - k + 1 == dq.peekFirst()) {
                    dq.removeFirst();
                }
            }
        }
        return res;
    }
    
    private void push(Deque<Integer> dq, int idx, int[] nums) {
        while (!dq.isEmpty() && nums[dq.peekLast()] < nums[idx]) {
            dq.removeLast();
        }
        dq.addLast(idx);
    }
}
