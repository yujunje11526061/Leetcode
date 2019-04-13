package medium;

public class IntegerReplacement397 {
    public static IntegerReplacement397 instance = new IntegerReplacement397();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.integerReplacement(2147483647));
    }

    class Solution {
        public int minC=0x7fffffff;
        public int integerReplacement(int n) {
            if(n==0x7fffffff){
                return 32;
            }
            find(n,0);
            return minC;
        }

        public void find(int num, int cnt){
            if(num==1) {
                minC = minC>cnt?cnt:minC;
                return;
            }
            cnt++;
            if((num&1)==0){
                find(num/2, cnt);
            }else{
                find(num+1,cnt);
                find(num-1,cnt);
            }
        }
    }
}
