package search;

/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    /**
     * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
        Example 1:
        Input: x = 2.00000, n = 10
        Output: 1024.00000

        Example 2:
        Input: x = 2.10000, n = 3
        Output: 9.26100

        Example 3:
        Input: x = 2.00000, n = -2
        Output: 0.25000
        Explanation: 2-2 = 1/22 = 1/4 = 0.25
    */
    // x ^ power
    // x ^ (2^n + k)
    // get n (0 <= n <= 31)
    // when n = 0, x
    // when n = 1, x * x
    // when n = 2, x * x * x * x
    // when n = 3, x * x * x * x * x * x * x * x
    // ...
    // + remaining k x's
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long power = n;
        if (n < 0) {
            power = -1L * n;
        }
        double ans = x;
        long num = 1;
        while (num * 2 <= power) {
            ans = ans * ans;
            num *= 2;
        }
        long left = power - num;
        while (left > 0) {
            ans = ans * x;
            --left;
        }
        if (n < 0) {
            return 1 / ans;
        }
        return ans;
    }
}

// @lc code=end

