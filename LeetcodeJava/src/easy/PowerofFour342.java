package easy;

public class PowerofFour342 {

    class Solution {
        public boolean isPowerOfFour(int num) {
            if ((num & (-num)) != num || num<=0) {
                return false;
            }
            if((num&0x55555555)!=num){
                return false;
            }
            return true;
        }
    }
}
