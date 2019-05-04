package hard;

import java.util.Arrays;

public class MaximumGap164 {
    public static MaximumGap164 instance = new MaximumGap164();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,5,5,5,5,5};
        System.out.println(instance.solution.maximumGap(nums));
    }

    class Solution {
        /*
        分成N个桶，每个桶记录最大值和最小值。则最大gap必然不小于桶宽
        因为如果按桶均匀分配，每桶一个，则最小的gap一定是均匀距离，且为桶宽，否则任意一个数左偏或右偏都会导致其中一边间距变大
        若按桶不均匀分配，那么必在空桶，则存在隔开至少一个桶的gap，必然大于桶内gap。
        故可能的最大gap一定是跨桶产生的，桶间gap为当前桶最小值和前一个非空桶的最大值的差
        故只需扫描各桶，看当前桶最小值和前一个非空桶的最大值的差，最大的差就是所求的gap
        * */
        public int maximumGap(int[] nums) {
            if(nums==null|| nums.length<2){
                return 0;
            }
            int MAX = 0;
            int MIN = 0x7fffffff;
            for(int x:nums){
                MAX = Math.max(MAX,x);
                MIN = Math.min(MIN,x);
            }
            if(MAX==MIN){
                return 0;
            }
            int bucketSize = (int)Math.ceil((MAX-MIN)*1.0/nums.length);

            int[] bucketMin = new int[nums.length+1];
            int[] bucketMax = new int[nums.length+1];
            Arrays.fill(bucketMax, MIN);
            Arrays.fill(bucketMin, MAX);
            for(int x:nums){
                int bucketNum = (x-MIN)/bucketSize;
                bucketMax[bucketNum] = Math.max(bucketMax[bucketNum], x);
                bucketMin[bucketNum] = Math.min(bucketMin[bucketNum], x);
            }
            int preMax = MIN;
            int maxGap = bucketSize;
            for(int i=0;i<bucketMax.length;i++){
                if(bucketMax[i]==MIN && bucketMin[i]==MAX){
                    continue; // 空桶
                }
                maxGap = Math.max(maxGap, bucketMin[i]-preMax);
                preMax = bucketMax[i];
            }
            return maxGap;
        }
    }
}
