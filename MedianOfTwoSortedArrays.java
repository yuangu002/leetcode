import java.util.ArrayList;

public class MedianOfTwoSortedArrays {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            ArrayList<Integer> list = merge(nums1, nums2);
            if (list.size()%2==1) return list.get(list.size()/2);
            else {
                return (Double.valueOf(list.get(list.size()/2 - 1)) + Double.valueOf(list.get(list.size()/2)))/2;
            }
        }

        private ArrayList<Integer> merge(int[] num1, int[] num2){
            int l1= num1.length;
            int l2 = num2.length;
            ArrayList<Integer> tmp = new ArrayList<>();
            int ptr1=0, ptr2=0;
            while (ptr1 < l1 && ptr2 < l2){
                if (num1[ptr1] < num2[ptr2]){
                    tmp.add(num1[ptr1]);
                    ptr1++;
                }
                else if (num1[ptr1] > num2[ptr2]){
                    tmp.add(num2[ptr2]);
                    ptr2++;
                }
                else{
                    tmp.add(num1[ptr1]);
                    tmp.add(num2[ptr2]);
                    ptr1++;
                    ptr2++;
                }
            }

            while (ptr1 < l1){
                tmp.add(num1[ptr1]);
                ptr1++;
            }

            while (ptr2 < l2){
                tmp.add(num2[ptr2]);
                ptr2++;
            }
            return tmp;
        }
    }
}
