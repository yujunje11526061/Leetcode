package medium;

public class Powxn50 {
    public static Powxn50 instance = new Powxn50();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        double x = 2;
        int n = 0x80000000;
        double result = instance.solution.myPow(x, n);
        System.out.println(result);
    }

    class Solution {
        public double myPow(double x, int n) {
            if(n==0){
                return 1;
            }
            if(x==0){
                return 0;
            }
            x = n<0?1/x:x;
            n = n<0?-n:n;
            double result = 1;

            if(n==0x80000000){
                n = 0x7fffffff;
                result = x;
            }
            while(n>0){
                if((n&1)==1){
                    result = result*x;
                }
                n >>= 1;
                x *= x;
            }
            return result;
        }
    }
}
