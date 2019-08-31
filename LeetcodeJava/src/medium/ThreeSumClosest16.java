package medium;

import java.util.Arrays;

public class ThreeSumClosest16 {

    public static ThreeSumClosest16 instance= new ThreeSumClosest16();
    public Solution solution = new Solution();
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(instance.solution.threeSumClosest(nums, target));
    }

    class Solution {
        boolean flag = false;
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int sum = nums[0]+nums[1]+nums[2];
            for (int i = 0; i < nums.length-2 && !flag; i++) {
                for (int j = i + 1; j < nums.length-1 && !flag; j++) {
                    int left = target - nums[i] - nums[j];
                    int thisSum = nums[bSearch(nums, j + 1, nums.length - 1, left)] + nums[i] + nums[j];
                    if (Math.abs(thisSum - target) < Math.abs(sum - target)) {
                        sum = thisSum;
                    }
                }
            }
            if(flag) {
                return target;
            }
            return sum;
        }

        private int bSearch(int[] nums, int s, int e, int left) {
            if (left >= nums[e]) {
                return e;
            }
            if (left <= nums[s]) {
                return s;
            }
            while (s <= e) {
                int mid = (s + e) / 2;
                if (nums[mid] < left) {
                    s = mid + 1;
                } else if (nums[mid] > left) {
                    e = mid - 1;
                } else {
                    flag = true;
                    return mid;
                }
            }
            if(nums[s]-left<left-nums[e]){
                return s;
            }else{
                return e;
            }
        }
    }
}
