package medium;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence300 {
    public static LongestIncreasingSubsequence300 instance = new LongestIncreasingSubsequence300();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int result = instance.solution.lengthOfLIS(nums);
        System.out.println(result);
    }

    class Solution {
        private ArrayList<Integer> list = new ArrayList<>();
        public int lengthOfLIS(int[] nums) {
            for(int x:nums){
                if(this.list.isEmpty()){
                    this.list.add(x);
                    continue;
                }
                int loc = binarySearch(this.list, x);
                if(loc>=this.list.size()){
                    this.list.add(x);
                }else{
                    this.list.set(loc, x);
                }
            }
            return list.size();
        }

        public int binarySearch(List<Integer> l, int x){
            int s=0, e=l.size()-1;
            while(s<=e){
                int mid = (s+e)/2;
                if(l.get(mid)<x){
                    s = mid+1;
                }else{
                    e = mid-1;
                }
            }
            return s;
        }

    }
}
