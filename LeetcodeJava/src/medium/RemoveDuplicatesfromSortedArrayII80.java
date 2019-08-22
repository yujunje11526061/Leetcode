package medium;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArrayII80 {
    public static RemoveDuplicatesfromSortedArrayII80 instance = new RemoveDuplicatesfromSortedArrayII80();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(instance.solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums==null){
                return 0;
            }
            if(nums.length<3){
                return nums.length;
            }
            int p =1;
            int cnt=1;
            int prev = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if(nums[i]==prev){
                    cnt++;
                    if(cnt<3){
                        nums[p++] = nums[i];
                    }
                }else{
                    nums[p++]= nums[i];
                    cnt=1;
                    prev =nums[i];
                }
            }
            return p;
        }
    }
}
