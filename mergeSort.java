import java.util.*;
public class mergeSort {

    public static void mergeSortDriver(int nums[][]) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[][] temp = new int[nums.length][nums[0].length];
        mergeSortHelper(nums, 0, nums.length - 1, temp);
    }

    private static void mergeSortHelper(int nums[][], int start, int end, int[][] tmp) {
        if (start >= end) {
            return;
        }
        
        int mid = (start + end) / 2;
        mergeSortHelper(nums, start, mid, tmp);
        mergeSortHelper(nums, mid + 1, end, tmp);
        
        // merge two sorted array
        merge(nums, start, mid, end, tmp);
    }

    private static void merge(int[][] nums, int low, int mid, int high, int[][] tmp) {
        // merge two sorted array
        int ptrTmp = low, leftStart = low, rightStart = mid + 1;

        while (leftStart <= mid && rightStart <= high) {
            if (nums[leftStart][2] > nums[rightStart][2]) {
                tmp[ptrTmp++] = nums[leftStart++];
            } else if (nums[leftStart][2] < nums[rightStart][2]) {
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

        for (int i = low; i <= high; ++i) {
            nums[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[][] A = {{1,5,5,0}, {2,7,8,1}, {3,7,5,1}, {4,10,3,3}};
        mergeSortDriver(A);
        int total = 18;
        List<Integer> losers = new ArrayList<>();
        for (int i = 0; i < A.length; ++i) {
            if (total <= 0) {
                losers.add(A[i][0]);
            } else {
                total -= A[i][1];
            }
        }
        for (int j = 0; j < losers.size(); ++j) {
            System.out.println(losers.get(j));
        }
    }
}