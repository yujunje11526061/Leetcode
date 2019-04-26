package easy;

public class PowerofThree326 {
    public static PowerofThree326 instance = new PowerofThree326();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.isPowerOfThree(45));
    }

    class Solution {
        public boolean isPowerOfThree(int n) {
//        找出int范围内最大的3的幂次，那么小于他的任何3的幂次都能被他整除。
            return n > 0 && 1162261467 % n == 0;
        }
    }

}
