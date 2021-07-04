public class MergeSort {

    public static void mergeSortDriver(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] temp = new int[nums.length];
        mergeSortHelper(nums, 0, nums.length - 1, temp);
    }

    private static void mergeSortHelper(int nums[], int start, int end, int[] tmp) {
        if (start >= end) {
            return;
        }
        
        int mid = (start + end) / 2;
        mergeSortHelper(nums, start, mid, tmp);
        mergeSortHelper(nums, mid + 1, end, tmp);
        
        // merge two sorted array
        merge(nums, start, mid, end, tmp);
    }

    private static void merge(int[] nums, int low, int mid, int high, int[] tmp) {
        // merge two sorted array
        int ptrTmp = low, leftStart = low, rightStart = mid + 1;

        while (leftStart <= mid && rightStart <= high) {
            if (nums[leftStart] < nums[rightStart]) {
                tmp[ptrTmp++] = nums[leftStart++];
            } else if (nums[leftStart] > nums[rightStart]) {
                tmp[ptrTmp++] = nums[rightStart++];
            } else {
                tmp[ptrTmp++] = nums[leftStart++];
                tmp[ptrTmp++] = nums[rightStart++];
            }
        }

        while (leftStart <= mid) {
            tmp[ptrTmp++] = nums[leftStart++];
        }

        while (rightStart <= high) {
            tmp[ptrTmp++] = nums[rightStart++];
        }

        // copy the tmp array to the original array
        for (int i = low; i <= high; ++i) {
            nums[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 2, 1, 10, 9, -8};
        mergeSortDriver(A);

        for (int i = 0; i < A.length; ++i) {
            System.out.println(A[i]);
        }
    }
}
