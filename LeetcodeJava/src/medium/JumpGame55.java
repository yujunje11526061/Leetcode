package medium;

public class JumpGame55 {

    class Solution {
        public boolean canJump(int[] nums) {
            if(nums==null){
                return false;
            }
            if (nums.length == 0) {
                return true;
            }

            for (int i = 0; i < nums.length;) {
                if(nums.length-1-i<=nums[i]){
                    return true;
                }
                if(nums[i]==0){
                    return false;
                }
                int maxDistance= 0;
                int delta = 0;
                for (int j = 1; j <= nums[i] ; j++) {
                    int x = nums[i+j]+j;
                    if(maxDistance<=x){
                        maxDistance = x;
                        delta = j;
                    }
                }
                i += delta;
            }
            return true;
        }
    }
}
