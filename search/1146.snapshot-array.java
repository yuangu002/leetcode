package search;

import java.util.*;

/*
 * @lc app=leetcode id=1146 lang=java
 *
 * [1146] Snapshot Array
 */

// @lc code=start
class SnapshotArray {
    int snapId = 0;
    List<int[]>[] store;
    public SnapshotArray(int length) {
        store = new ArrayList[length];
        for (int i = 0; i < length; ++i) {
            store[i] = new ArrayList<>();
            store[i].add(new int[]{0, 0});
        }
    }
    
    public void set(int index, int val) {
        List<int[]> indexList = store[index];
        indexList.add(new int[]{snapId, val});
    }
    
    public int snap() {
        int tmp = snapId;
        snapId++;
        return tmp;
    }
    
    public int get(int index, int snap_id) {
        int lastSnapIdx = binarySearch(store[index], snap_id);
        return store[index].get(lastSnapIdx)[1];
    }

    /**
    [0,5], [0,8], [0,12], [1,6]
     */
    private int binarySearch(List<int[]> list, int snap_id) {
        /*for (int[] arr: list) {
            System.out.println("[" + arr[0] + "," + arr[1] + "]");
        }*/
        int start = 0;
        int end = list.size() - 1;

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            int[] set = list.get(mid);
            if (set[0] <= snap_id) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (list.get(end)[0] <= snap_id) {
            return end;
        } else {
            return start;
        }
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
// @lc code=end

