package medium;

public class ArithmeticSlices413 {
    public static ArithmeticSlices413 instance = new ArithmeticSlices413();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        System.out.println(instance.solution.numberOfArithmeticSlices(A));
    }
    class Solution {
        public int numberOfArithmeticSlices(int[] A) {
            if(A==null || A.length<3){
                return 0;
            }
            int result=0;
            int len=2;
            int prevDiff = A[1]-A[0];

            for (int i = 2; i < A.length; i++) {
                if(A[i]-A[i-1]==prevDiff){
                    len++;
                }else{
                    if(len>2){
                        result += calculateNum(len);
                    }
                    len = 2;
                    prevDiff = A[i]-A[i-1];
                }
            }
            if(len>2){
                result += calculateNum(len);
            }
            return result;
        }

        private int calculateNum(int len) {
            return (len-1)*(len-2)/2;
        }
    }
}
