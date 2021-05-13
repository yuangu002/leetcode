public class KLargestElement {
    
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int idx = partition(nums, start, end, start + (end - start)/2);
            if (idx == k-1) {
                return nums[idx];
            } else if (idx > k-1) {
                end = idx - 1;
            } else {
                start = idx + 1;
            }
        }
        return -1;
    }
    
    private int partition(int[] nums, int start, int end, int pivotidx) {
        int writeidx = start;
        int pivot = nums[pivotidx];
        swap(nums, pivotidx, end);
        
        for (int i = start; i <= end; ++i) {
            if (nums[i] > pivot) {
                swap(nums, writeidx, i);
                ++writeidx;
            }
        }
        swap(nums, writeidx, end);
        return writeidx;
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }    
}
