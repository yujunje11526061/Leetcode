package easy;


import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class ShortestUnsortedContinuousSubarray581 {

    public static ShortestUnsortedContinuousSubarray581 instance = new ShortestUnsortedContinuousSubarray581();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(instance.solution.findUnsortedSubarray(nums));
    }

//    class Solution {
//        public int findUnsortedSubarray(int[] nums) {
//            int[] x = nums.clone();
//            Arrays.sort(x);
//            int left=0;
//            int right=0;
//            for(int i=0;i<nums.length;i++){
//                if(x[i]!=nums[i]){
//                    left = i;
//                    break;
//                }
//            }
//            for(int j=nums.length-1;j>=0;j--){
//                if(x[j]!=nums[j]){
//                    right = j;
//                    break;
//                }
//            }
//            return right==left?0:right-left+1;
//        }
//    }

    class Solution {

        public int findUnsortedSubarray(int[] nums) {
            int m = nums[0], n = nums[nums.length-1], l = -1, r = -2;
            int len = nums.length;
            for (int i = 1; i < len; ++i)
            {
                m = Integer.max(m, nums[i]);
                n = Integer.min(n, nums[len - 1 - i]);
                // 找到左边的最大值实际应该在的位置
                if (m != nums[i]) r = i;
                // 找到右边的最小值实际应该在的位置
                if (n != nums[len - 1 - i]) l = len - 1 - i;
            }
            return r - l + 1;
        }
    }
}
