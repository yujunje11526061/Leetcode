package easy;

public class ReverseInteger7 {

    class Solution {
        public int reverse(int xx) {
            long x = xx;
            boolean flag = x<0?true:false;
            x = x<0?-x:x;
            long result = 0;
            while(x>0){
                long y = x%10;
                x = x/10;
                result = result*10+y;
            }
            if(result>Integer.MAX_VALUE){
                return 0;
            }
            if(flag && result<Integer.MIN_VALUE){
                return 0;
            }
            return (int) (flag ? -result : result);
        }
    }
}
