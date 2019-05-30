package medium;


public class CombinationSumIV377 {
    public static CombinationSumIV377 instance = new CombinationSumIV377();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 7, 8, 9, 10, 11};
        int target = 10;
        System.out.println(instance.solution.combinationSum4(nums, target));
    }
//    class Solution {
//        private int cnt = 0;
//        private int[] table;
//        public int combinationSum4(int[] nums, int target) {
//            if (nums == null || nums.length == 0 || target <= 0) {
//                return 0;
//            }
//            table = nums;
//            for (int i = 0; i < table.length; i++) {
//                find(i, target);
//            }
//            return cnt;
//        }
//        private void find(int i, int target) {
//            target -= table[i];
//            if (target < 0) {
//                return;
//            }
//            if (target == 0) {
//                cnt++;
//            } else {
//                for (int j = 0; j < table.length; j++) {
//                    find(j, target);
//                }
//            }
//        }
//    }

    //dfs会超时
    //使用dp数组，dp[i]代表组合数为i时使用nums中的数能组成的组合数的个数
    //别怪我写的这么完整
    //dp[i]=dp[i-nums[0]]+dp[i-nums[1]]+dp[i=nums[2]]+...
    //举个例子比如nums=[1,3,4],target=7;
    //dp[7]=dp[6]+dp[4]+dp[3]
    //其实就是说7的组合数可以由三部分组成，1和dp[6]，3和dp[4],4和dp[3];
//    int[]dp=new int[target+1];
    //是为了算上自己的情况，比如dp[1]可以由dp[0]和1这个数的这种情况组成。

    class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] result = new int[target + 1];
            result[0] = 1;
            for (int i = 0; i <= target; i++) {
                for (int num:nums) {
                    if(i>=num) {
                        result[i] += result[i-num];
                    }
                }
            }
            return result[target];
        }
    }
}
