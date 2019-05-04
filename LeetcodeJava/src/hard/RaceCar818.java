package hard;

public class RaceCar818 {
    public static RaceCar818 instance = new RaceCar818();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.racecar(5));
    }

    // 完全的贪心做法每次都尽可能逼近行不通，对于5，可以AARARAA，先拉远再逼近，共7个指令，比贪心的8个少
    // 但是可以贪心n-1次直到第n次就冲过头，后面再比较是冲过头再回退好还是现在就回退好
    // 关键在于可以有多种回退长度，并不一定是原地掉头再掉头更好（对应于回退0，仅仅为了重置速度），故需要一个循环尝试多种m。最多回退m<n-1次（否则不是前面都无用功了？）
    class Solution {
        int[] dp = new int[10001];

        public int racecar(int target) {
            if (dp[target] > 0) return dp[target];
            int n = (int) (Math.log(target) / Math.log(2)) + 1;
            if (1 << n == target + 1) dp[target] = n;
            else {
                dp[target] = racecar((1 << n) - 1 - target) + n + 1; // 冲过头的情形
                for (int m = 0; m < n - 1; m++) // 遍历各种回退的情形
                    dp[target] = Math.min(dp[target], racecar(target - (1 << (n - 1)) + (1 << m)) + n - 1 + 1 + m + 1);
            }
            return dp[target];
        }
    }
}
