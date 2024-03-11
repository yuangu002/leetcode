package advanced_dsa;
import java.util.*;

class SummaryRanges {
    TreeMap<Integer, Entry> map;
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int value) {
        Integer lower = map.floorKey(value);
        Integer higher = map.ceilingKey(value);
        if (lower == null) {
            lower = Integer.MIN_VALUE;
        }
        if (higher == null) {
            higher = Integer.MAX_VALUE;
        }
        if (isNoOps(lower, higher)) {
            return;
        }
        // merge both
        if (lower + 1 == value && value + 1 == higher) {
            Entry lowArr = map.get(lower);
            Entry highArr = map.get(higher);
            Entry newArr = new Entry(lowArr.low, highArr.high);
            map.remove(lower);
            map.remove(higher);
            map.put(newArr.low, newArr);
            map.put(newArr.high, newArr);
        } else if (lower + 1 == value) { // merge lower end
            Entry lowArr = map.get(lower);
            Entry newArr = new Entry(lowArr.low, value);
            map.remove(lower);
            map.put(newArr.low, newArr);
            map.put(newArr.high, newArr);
        } else if (value + 1 == higher) { // merge higher end
            Entry highArr = map.get(higher);
            Entry newArr = new Entry(value, highArr.high);
            map.remove(higher);
            map.put(newArr.low, newArr);
            map.put(newArr.high, newArr);
        } else { // no merge
            Entry newArr = new Entry(value, value);
            map.put(newArr.low, newArr);
            map.put(newArr.high, newArr);
        }
    }
    
    public int[][] getIntervals() {
        Set<Entry> set = new TreeSet<Entry>((a, b) -> a.low - b.low);
        for (int key: map.keySet()) {
            set.add(map.get(key));
        }
        int[][] res = new int[set.size()][2];
        int idx = 0;
        for (Entry entry: set) {
            res[idx++] = new int[]{entry.low, entry.high};
        }
        return res;
    }

    private boolean isNoOps(int lb, int hb) {
        Entry a = map.get(lb);
        Entry b = map.get(hb);
        return a != null && b != null && a == b;
    }
}

class Entry {
    int low;
    int high;
    public Entry(int low, int high) {
        this.low = low;
        this.high = high;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        Entry entry = (Entry)other;
        return this.low == entry.low && this.high == entry.high;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
