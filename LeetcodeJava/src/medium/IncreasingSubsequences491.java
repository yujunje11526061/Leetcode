package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IncreasingSubsequences491 {
    public static IncreasingSubsequences491 instance = new IncreasingSubsequences491();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7,4};
        List<List<Integer>> result = instance.solution.findSubsequences(nums);
        System.out.println(result);
    }


    class Solution {
        public List<List<Integer>> findSubsequences(int[] nums) {
            HashSet<List<Integer>> set = new HashSet<>();
            ArrayList<Integer> temp = new ArrayList<>();
            if (nums.length < 2) {
                return new ArrayList<List<Integer>>();
            }
            for (int i = 0; i < nums.length - 1; i++) {
                temp.add(nums[i]);
                find(i + 1, nums[i], nums, set, temp);
                temp.remove(temp.size() - 1);
            }
            List<List<Integer>> result = new ArrayList<List<Integer>>(set);

            return result;
        }

        public void find(int p, int prev, int[] nums, HashSet<List<Integer>> set, ArrayList<Integer> temp) {
            for (int i = p; i < nums.length; i++) {
                if (nums[i] >= prev) {
                    temp.add(nums[i]);
                    set.add(new ArrayList<Integer>(temp));
                    find(i + 1, nums[i], nums, set, temp);
                    temp.remove(temp.size() - 1);
                } else {
                    find(i + 1, prev, nums, set, temp);
                }
            }
        }
    }
}

