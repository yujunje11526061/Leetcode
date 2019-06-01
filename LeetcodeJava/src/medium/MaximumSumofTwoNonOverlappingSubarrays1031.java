package medium;

public class MaximumSumofTwoNonOverlappingSubarrays1031 {
    public static MaximumSumofTwoNonOverlappingSubarrays1031 instance = new MaximumSumofTwoNonOverlappingSubarrays1031();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] A = {1,0,3};
        int L = 1;
        int M = 2;
        System.out.println(instance.solution.maxSumTwoNoOverlap(A, L, M));
    }

    class Solution {
        public int maxSumTwoNoOverlap(int[] A, int L, int M) {
            //转化为累积和
            for (int i = 1; i < A.length; i++) {
                A[i] += A[i - 1];
            }
            int[] maxL = new int[A.length];
            int[] maxM = new int[A.length];
            int result = 0;
            for (int i = 0; i < A.length; i++) {
                // 动态规划求出到位置i时，长度为L的最大连续子列和，不足L长度则和递增，直接取A[i]即可。
                if (i >= L) {
                    maxL[i] = maxL[i - 1] > A[i] - A[i - L] ? maxL[i - 1] : A[i] - A[i - L];
                } else {
                    maxL[i] = A[i];
                }
                // 长度为M同理
                if (i >= M) {
                    maxM[i] = maxM[i - 1] > A[i] - A[i - M] ? maxM[i - 1] : A[i] - A[i - M];
                }else{
                    maxM[i] = A[i];
                }
                if(i>=M+L-1) {
                    int a = A[i] - A[i - L] + maxM[i-L]; // M在前
                    int b = A[i] - A[i - M] + maxL[i-M]; // L在前
                    int temp = a>b?a:b;
                    result = result>temp?result:temp;
                }
            }
            return result;
        }
    }
}
