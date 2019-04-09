package medium;

public class SuperPow372 {
    public static SuperPow372 instance = new SuperPow372();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int a = 2;
        int[][] bb = {
                {1, 0}
                };
        for(int i=0;i<bb.length;i++){
            int result = instance.solution.superPow(a,bb[i]);
            System.out.println(result);
        }
    }

//    a^1234567 % k = (a^1234560 % k) * (a^7 % k) % k = (a^123456 % k)^10 % k * (a^7 % k) % k
//    Looks complicated? Let me put it other way:
//    Suppose f(a, b) calculates a^b % k; Then translate above formula to using f :
//    f(a,1234567) = f(a, 1234560) * f(a, 7) % k = f(f(a, 123456),10) * f(a,7)%k;
    class Solution {
        private int mod = 1337;
        private int[] myb;
        private int a;
        public int superPow(int a, int[] b) {
            this.myb = b;
            this.a = a%mod;
            return superPow(this.a,b.length-1)%mod;
        }

        public int superPow(int a, int p){
            if (p==0){
                return quickPow(a,this.myb[p])%mod;
            }
            return (quickPow(superPow(a,p-1),10)%mod)*(quickPow(a,this.myb[p])%mod)%mod;
        }

        private int quickPow(int base, long exp){
            int result = 1;
            while(exp>0){
                if((exp&1)!=0){
                    result = result*base%mod;
                }
                exp >>= 1;
                base = base*base%mod;
            }
            return result;
        }
    }
}
