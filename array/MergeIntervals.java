package array;

import java.util.*;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int idx = 0;
        while (idx < intervals.length) {
            int tmp = idx;
            int max_upper = intervals[idx][1];
            // 固定左端，寻找最大的右端
            while (idx < intervals.length - 1 && 
                   intervals[idx+1][0] <= max_upper) {
                max_upper = Math.max(max_upper, intervals[idx+1][1]);
                ++idx;
            }
            res.add(new int[]{intervals[tmp][0], max_upper});
            ++idx;
        }
        
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
