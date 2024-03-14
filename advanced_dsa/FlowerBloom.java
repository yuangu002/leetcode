package advanced_dsa;

import java.util.*;

/**
 * You are given a 0-indexed 2D integer array flowers, where flowers[i] = [starti, endi] means the ith flower will be in full bloom from starti to endi (inclusive).
 * You are also given a 0-indexed integer array people of size n, where people[i] is the time that the ith person will arrive to see the flowers.
    Return an integer array answer of size n, where answer[i] is the number of flowers that are in full bloom when the ith person arrives.

    Example 1:

    Input: flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]
    Output: [1,2,2,2]
    Explanation: The figure above shows the times when the flowers are in full bloom and when the people arrive.
    For each person, we return the number of flowers in full bloom during their arrival.
 */
class FlowerBloom {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] sortedArrivals = people.clone();
        Arrays.sort(sortedArrivals);
        Arrays.sort(flowers, (a, b) -> a[0] - b[0]);
        Map<Integer, Integer> bloomCounts = new HashMap<>();
        PriorityQueue<Integer> bloomFlowers = new PriorityQueue<>();

        int idx = 0;

        for (int time: sortedArrivals) {
            while (idx < flowers.length && flowers[idx][0] <= time) {
                bloomFlowers.offer(flowers[idx][1]);
                ++idx;
            }

            while (!bloomFlowers.isEmpty() && bloomFlowers.peek() < time) {
                bloomFlowers.poll();
            }

            bloomCounts.put(time, bloomFlowers.size());
        }
        
        int[] ans = new int[people.length];
        for (int i = 0; i < people.length; ++i) {
            ans[i] = bloomCounts.getOrDefault(people[i], 0);
        }
        return ans;
    }
}
