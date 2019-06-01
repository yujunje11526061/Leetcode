package easy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class LongestHarmoniousSubsequence594 {
    public static LongestHarmoniousSubsequence594 instance = new LongestHarmoniousSubsequence594();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,1,-14,13,4};
        System.out.println(instance.solution.findLHS(nums));
    }
    class Solution {
        public int findLHS(int[] nums) {
            if(nums==null||nums.length==0){
                return 0;
            }
            Map<Integer,Integer> map = new TreeMap<>();
            for(int i:nums){
                map.merge(i,1,Integer::sum);
            }
            Iterator iterator = map.entrySet().iterator();
            Map.Entry<Integer,Integer> pre = (Map.Entry<Integer, Integer>) iterator.next();
            int maxCnt = 0;
            while(iterator.hasNext()){
                Map.Entry<Integer,Integer> now = (Map.Entry<Integer, Integer>) iterator.next();
                if(now.getKey()-pre.getKey()==1){
                    int cnt = now.getValue()+pre.getValue();
                    maxCnt = maxCnt>cnt?maxCnt:cnt;
                }
                pre = now;
            }
            return maxCnt;
        }
    }

//    class Solution {
//        public int findLHS(int[] nums) {
//            Arrays.sort(nums);
//            int begin = 0,res = 0;
//            for(int end = 0;end < nums.length;end++){
//                while(nums[end] - nums[begin] > 1)
//                    begin++;
//                if(nums[end] - nums[begin] == 1)
//                    res = Math.max(res,end - begin + 1);
//            }
//            return res;
//        }
//    }
}
