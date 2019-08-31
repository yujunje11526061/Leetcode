package easy;

import medium.RemoveDuplicatesfromSortedArrayII80;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray26 {
    public static RemoveDuplicatesfromSortedArray26 instance = new RemoveDuplicatesfromSortedArray26();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(instance.solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums.length<1){
                return nums.length;
            }
            int pre = 0;
            for (int i = 1; i < nums.length; i++) {
                if(nums[i]!=nums[pre]){
                    if(pre+1<i) {
                        nums[pre+1] = nums[i];
                    }
                    pre++;
                }
            }
            return pre+1;
        }
    }
}
