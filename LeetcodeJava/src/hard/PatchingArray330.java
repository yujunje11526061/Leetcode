package hard;

import java.util.ArrayList;
import java.util.Arrays;

public class PatchingArray330 {
    public Solution solution = new Solution();
    public static PatchingArray330 instance = new PatchingArray330();

    public static void main(String[] args) {
        int[] nums = {1, 2, 31, 33};
        int n = 2147483647;
        int result = instance.solution.minPatches(nums, n);
        System.out.println(result);
    }


//    class Solution {
//        public int minPatches(int[] nums, int n) {
//            long maxCover = 0;
//            int i=0, j = 0;
//            int patchCnt = 0;
//            for (i = 1; j<nums.length &&i <= n; i++) {
//                while (j < nums.length && i >= nums[j]) {
//                    maxCover += nums[j];
//                    j++;
//                }
//                if (i > maxCover) {
//                    patchCnt++;
//                    maxCover += i;
//                }
//            }
//            if(j== nums.length && i<n){
//                while(maxCover<n){
//                    maxCover <<= 1;
//                    maxCover++;
//                    patchCnt++;
//                }
//            }
//            return patchCnt;
//        }
//    }

    class Solution {
        public int minPatches(int[] nums, int n) {
            long maxCover = 0;
            int j = 0;
            int patchCnt = 0;
            while (maxCover<n){
                if(j<nums.length && nums[j]<=maxCover+1){ //数组中最小的那个数是否是目前覆盖边界的下一个数
                    maxCover+= nums[j];
                    j++;
                }
                else { // 不是则需要插入这个数，覆盖边界为原来的两倍+1
                    maxCover <<= 1;
                    maxCover++;
                    patchCnt++;
                }

            }
            return patchCnt;
        }
    }
}
