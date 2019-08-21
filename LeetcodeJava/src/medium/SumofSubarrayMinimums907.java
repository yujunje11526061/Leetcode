package medium;

import java.util.Stack;

public class SumofSubarrayMinimums907 {

    public static SumofSubarrayMinimums907 instance = new SumofSubarrayMinimums907();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4};
        int[] A2 = {71, 55, 82, 55};
        int[] A3 = {4, 3};
        System.out.println(instance.solution.sumSubarrayMins(A2));
    }

    // 求所有连续子数组中的最小值之和
    // 对每个A[i]找两侧第一个比自身小的数的位置left，第一个不大于自身的数的位置right，从而可以得知以自身为最小值的连续子数组的个数为(i-left)*(right-i)
    class Solution {
        public int sumSubarrayMins(int[] A) {
            if (A == null || A.length == 0) {
                return 0;
            }
            int sum = 0;
            Stack<Integer> stack = new Stack<>();
            int[] leftBound = new int[A.length];
            int[] rightBound = new int[A.length];
            for (int i = 0; i < A.length; i++) {
                while ((!stack.isEmpty()) && A[stack.peek()] > A[i]) {
                    int p = stack.pop();
                    rightBound[p] = i;
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                int p = stack.pop();
                rightBound[p] = A.length;
            }

            for (int j = A.length - 1; j >= 0; j--) {
                while ((!stack.isEmpty()) && A[stack.peek()] >= A[j]) {
                    int p = stack.pop();
                    leftBound[p] = j;
                }
                stack.push(j);
            }
            while (!stack.isEmpty()) {
                int p = stack.pop();
                leftBound[p] = -1;
            }
            for (int k = 0; k < A.length; k++) {
                sum = (sum + A[k] * (k - leftBound[k]) * (rightBound[k] - k)) % 1000000007;
            }
            return sum;
        }
    }

    // 更优解法，利用单调栈，遍历一遍即可
    /*
    class Solution:
    def sumSubarrayMins(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        ans = 0
        A = [float('-inf')] + A + [float('-inf')]
        stack = []
        for i, a in enumerate(A):
            while stack and A[stack[-1]] > a:
                cur = stack.pop()
                ans += A[cur] * (i-cur) * (cur-stack[-1])
            stack.append(i)
        return ans % (10**9 + 7)
     */
}
