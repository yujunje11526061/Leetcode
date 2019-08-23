package medium;

public class PartitionArrayforMaximumSum1043 {

    public static PartitionArrayforMaximumSum1043 instance = new PartitionArrayforMaximumSum1043();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] A = {1,15,7,9,2,5,10};
        System.out.println(instance.solution.maxSumAfterPartitioning(A,3));
    }

    class Solution {
        public int maxSumAfterPartitioning(int[] A, int K) {
            int[] sum = new int[A.length];
            sum[0] = A[0];
            for (int i = 1; i <A.length ; i++) {
                int prevMax = A[i];
                for (int j = 0; j <K ; j++) {
                    if (i >= j) {
                        prevMax = Integer.max(prevMax, A[i - j]);
                        sum[i] = Integer.max(sum[i], prevSum(i - j - 1, sum) + (j + 1) * prevMax);
                    }
                }
            }
            return sum[A.length-1];

        }

        private int prevSum(int prev, int[] sum) {
            if(prev<0){
                return 0;
            }else{
                return sum[prev];
            }
        }
    }
}
