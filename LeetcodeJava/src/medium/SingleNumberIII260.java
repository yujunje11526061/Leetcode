package medium;

public class SingleNumberIII260 {

    class Solution {
        public int[] singleNumber(int[] nums) {

            int xorForAll = 0;
            for (int x : nums) {
                xorForAll ^= x;
            }
            int flag = xorForAll & (-xorForAll);

            //最终异或的结果一定是答案a^b的结果，故随便取一位，a和b只能有一个是1
            //从而可以以该位是否为1对原数组分类。
            int a = 0, b = 0;
            for (int x : nums) {
                if ((flag & x) == 0) {
                    a ^= x;
                } else {
                    b ^= x;
                }
            }
            return new int[]{a,b};
        }
    }
}
