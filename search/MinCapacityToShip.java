package search;

/**
 * Meta Phone Screen (04/05/2024)
 * Leetcode 1011: Capacity To Ship Packages Within D Days
 * 
 * Given an array W and number of day D, each element of which indicates a workload to ship,
 * you can only process workloads in sequential order. The capacity of a day is defined as
 * the sum of workloads shipped.
 *
 * Returns the minimum capacity within D days.
 * 
 * Example: W = [3,2 | 1,5 | 2,4], D = 3 -> return 6
 */
public class MinCapacityToShip {
    public int shipWithinDays(int[] w, int d) {
        int minCapacity = 0;
        int maxCapacity = 0;
        for (int i = 0; i < w.length; ++i) {
            minCapacity = Math.max(minCapacity, w[i]);
            maxCapacity += w[i];
        }

        while (minCapacity + 1 < maxCapacity) {
            int capacity = (minCapacity + maxCapacity) / 2;
            int day = getMinimumDay(w, capacity);
            if (day <= d) {
                maxCapacity = capacity;
            } else {
                minCapacity = capacity;
            }
        }
        if (getMinimumDay(w, minCapacity) <= d) {
            return minCapacity;
        }
        return maxCapacity;
    }

    private int getMinimumDay(int[] w, int capacity) {
        int day = 0;
        int index = 0;
        int curWeight = 0;
        while (index < w.length) {
            while (index < w.length && curWeight + w[index] <= capacity) {
                curWeight += w[index];
                index++;
            }
            day++;
            curWeight = 0;
        }
        return day;
    }
}
