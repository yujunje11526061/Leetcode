package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations46 {
    public static Permutations46 instance = new Permutations46();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(instance.solution.permute(nums));
    }

    class Solution {
        private int[] nums;
        private List<List<Integer>> result = new ArrayList<>();
        private ArrayList<Integer> arrayList = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            if(nums==null || nums.length==0){
                return result;
            }
            this.nums = nums;
            permute(0);
            return result;
        }

        private void permute(int loc) {
            if(loc==nums.length){
                ArrayList<Integer> newArrayList = new ArrayList<>(arrayList);
                result.add(newArrayList);
                return;
            }
            for(int i=loc;i<nums.length;i++){
                swap(i,loc);
                arrayList.add(nums[loc]);
                permute(loc+1);
                swap(i,loc);
                arrayList.remove(arrayList.size()-1);
            }
        }

        private void swap(int a,int b){
            int x=nums[a];
            nums[a] = nums[b];
            nums[b] = x;
        }
    }
}
