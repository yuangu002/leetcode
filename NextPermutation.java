public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i;
        for (i = nums.length-1; i > 0; i--){
            if (nums[i] > nums[i-1]){
                int j = nums.length - 1;
                for (int k = i; k < nums.length; k++){
                    if (nums[k] <= nums[i-1]){
                        j = k-1;
                        break;
                    }
                }
                // swap i-1 and j
                swap (nums, i-1, j);
                break;
            }
        }
        
        // reverse from i to the end
        reverse (nums, i, nums.length-1);
    }
    
    private void swap (int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse (int[] nums, int i, int j){
        while (i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
