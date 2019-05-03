package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
    public static CombinationSum39 instance = new CombinationSum39();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(instance.solution.combinationSum(candidates, target));
    }

    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            for(int i=0;i<candidates.length;i++) {
                find(i, target, candidates);
            }
            return result;
        }

        private void find(int loc, int sum, int[] table) {
            sum -= table[loc];
            if (sum < 0) {
                return;
            }
            list.add(table[loc]);
            if (sum == 0) {
                ArrayList<Integer> arrayList = new ArrayList<>(list);
                result.add(arrayList);
            } else {
                for (int i = loc; i < table.length; i++) {
                    find(i, sum , table);
                }
            }
            list.remove(list.size() - 1);
        }
    }
}
