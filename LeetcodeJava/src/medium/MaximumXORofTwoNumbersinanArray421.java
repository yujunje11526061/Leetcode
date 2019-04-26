package medium;

import java.util.Arrays;
import java.util.HashSet;

public class MaximumXORofTwoNumbersinanArray421 {
    public static MaximumXORofTwoNumbersinanArray421 instance = new MaximumXORofTwoNumbersinanArray421();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums =  {3, 10, 5, 25, 2, 8};
        System.out.println(instance.solution.findMaximumXOR(nums));
    }

    class Solution {
        public int findMaximumXOR(int[] nums) {
            /*
            贪婪思想，要得到最大的异或，则尽可能获得多的高位1，那么不妨从高位开始考量，先不管低位的，每得到一个可能的高位异或值后，再更进一步考虑能不能获得低位的1
            因此用一个mask依次和各个数 与 ，截取高位的情况，mask的构造成111100000...00这样，表示当前只考虑前三位
            然后看期望能不能获得期望的高位1
            若 A = C^B， 则A^B = C^B^B = C
            故可以用期望值^一个值，看数组中是否有另一个值来判断是否能取到该期望值
            * */
            int mask = 0, max = 0;
            for(int i=31;i>=0;i--){
                mask = mask | (1<<i); // mask = mask + (1<<i) 同理，但是位运算更快
                HashSet<Integer> hashSet = new HashSet<>();
                for(int x : nums){
                    hashSet.add(x&mask); // 当前只考虑高位的影响，故把后面的先不管
                }
                int desiredResult = max | (1<<i); // 已经得到某个可取的异或结果后，看后面低位能不能再取一个1
                for(int x : hashSet){
                    if(hashSet.contains(x^desiredResult)){ // 若存在，则代表该期望值可以取到，更新最大异或值，跳出循环
                        max = desiredResult;
                        break;
                    }
                }
            }
            // 32轮贪婪后得到的就是最终最大的值。
            return max;
        }

    }
}
