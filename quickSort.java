
public class QuickSort {

    public void quickSortDriver(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSortHelper(nums, 0, nums.length - 1);
    }

    private void quickSortHelper(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start, right = end;
        // 1. choose pivot
        int pivot = nums[(left + right)/2];

        // 2. partition
        while (left <= right) {
            // 防止[1, 1, 1, 1, 1]这种特殊情况，nums[idx] == pivot时可左可右
            
            // find the mismatched(<= pivot) on the right
            while (left <= right && nums[right] > pivot) {
                --right;
            }
            // find the mismatched(>= pivot) on the left
            while (left <= right && nums[left] < pivot) {
                ++left;
            }

            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                --right;
                ++left;
            }
        }

        // 3. recurse on both parts
        quickSortHelper(nums, start, right);
        quickSortHelper(nums, left, end);
    }
}
