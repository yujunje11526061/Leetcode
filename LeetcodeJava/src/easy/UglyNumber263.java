package easy;

public class UglyNumber263 {
    public static UglyNumber263 instance = new UglyNumber263();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.isUgly(1023));
    }

    class Solution {
        public boolean isUgly(int num) {
            if(num==1){
                return true;
            }
            if(num<=0){
                return false;
            }
            while((num&1)==0){
                num >>= 1;
            }
            while(num%3==0){
                num /= 3;
            }
            while(num%5==0){
                num /= 5;
            }
            return num==1;
        }
    }

}
