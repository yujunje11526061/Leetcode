package easy;

public class MinimumMovestoEqualArrayElements453 {
    public static MinimumMovestoEqualArrayElements453 instance = new MinimumMovestoEqualArrayElements453();
    public Solution solution = new Solution();
    public static void main(String[] args) {
        int[] nums = {83,86,77,15,93,35,86,92,49,21};
        int result = instance.solution.minMoves(nums);
        System.out.println(result);
    }

    class Solution {
        public int minMoves(int[] nums) {
            int MIN = 0x7fffffff;
            int tot = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<MIN){
                    tot += (MIN-nums[i])*i;
                    MIN = nums[i];
                }
                else{
                    tot += nums[i]-MIN;
                }
            }
            return tot;
        }
    }
}
