package easy;

public class ValidPerfectSquare367 {
    public static ValidPerfectSquare367 instance = new ValidPerfectSquare367();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.isPerfectSquare(808201));
        System.out.println(Math.sqrt(808201));
    }

    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num <= 0) {
                return false;
            }
            if (num == 1 || num == 4 || num == 9) {
                return true;
            }
            if (num < 16) {
                return false;
            }
            int low = 1, high = num / 3;
            while (low <= high) {
                long mid = (low + high) >> 1;
                long x = mid * mid;
                if (x == num) {
                    return true;
                } else if (x < num) {
                    low = (int) mid + 1;
                } else {
                    high = (int) mid - 1;
                }
            }
            return false;

//            1+3+5+7+9+…+(2n-1)=n^2
//            int sum=0;
//            for(int i=1;sum<num;i = i+2){
//                sum += i;
//            }
//            if(sum==num){
//                return true;
//            }
//            return false;
//        }

        }
    }
}
