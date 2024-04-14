package search;
import java.util.*;

class MinJobEffort {
    int[][] memo;
    /**
     * TikTok VO (2024/03/19)
     * Leetcode 1335: Minimum Difficulty of a Job Schedule
     *
     * Design a schedule that completes n jobs in k days with minimal total "effort".
     * We define "effort" as the maximal job difficulty of a day, and "total effort"
     * as the sum of efforts of all days.
     *
     * Constraints:
     * - All jobs need to be completed in exactly k days, not less and not more.
     * - You can only process jobs in the given sequential order.
     * - There's at least 1 job scheduled every day.
     *
     * Examples:
     * [4,5,3,1,7,8], 3 -> return 14 with schedule: [4,5,3], [1], [7,8]
     * @param jobs a list of integers, each indicating the difficulty of the job
     * @param k number of days
     * @return the minimal effort
     */
    public int getMinTotalEffort(int[] jobs, int k) {
        // 0 -> n - k + 1
        // start + 1, k - 1
        if (k > jobs.length) {
            return -1;
        }
        memo = new int[jobs.length][k + 1];
        for (int i = 0; i < jobs.length; ++i) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(jobs, 0, k);
    }

    private int dfs(int[] jobs, int start, int day) {
        if (memo[start][day] != -1) {
            return memo[start][day];
        }
        if (day == 1) {
            int res = 0;
            for (int i = start; i < jobs.length; ++i) {
                res = Math.max(res, jobs[i]);
            }
            memo[start][1] = res;
            return res;
        }
        int maxDifficulty = 0;
        int minEffort = Integer.MAX_VALUE;
        for (int i = start; i < jobs.length - day + 1; ++i) {
            maxDifficulty = Math.max(maxDifficulty, jobs[i]);
            minEffort = Math.min(minEffort, maxDifficulty + dfs(jobs, i + 1, day - 1));
        }
        memo[start][day] = minEffort;
        return minEffort;
    }
}
