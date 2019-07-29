package hard;

public class JumpGameII45 {

    class Solution {
        public int jump(int[] nums) {

            if (nums.length <= 1) {
                return 0;
            }
            int cnt = 0;
            for (int i = 0; i < nums.length;) {
                if(nums.length-1-i<=nums[i]){
                    return cnt+1;
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
                cnt++;
            }
            return cnt;
        }
    }
}
