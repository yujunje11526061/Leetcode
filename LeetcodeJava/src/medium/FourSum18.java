package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {
    public static FourSum18 instance = new FourSum18();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        int target = -1;
        System.out.println(instance.solution.fourSum(nums,target));
    }

    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length < 4) {
                return result;
            }
            Arrays.sort(nums);
            // 注意三个地方要进行去重剪枝
            for (int i = 0; i < nums.length - 3; i++) {
                if(i>0 && nums[i-1]==nums[i]){
                    continue;
                }
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if(j>i+1 && nums[j-1]==nums[j]){
                        continue;
                    }
                    int x = target - nums[i] - nums[j];
                    int p = j + 1, q = nums.length - 1;
                    if (x < nums[p] + nums[p + 1] || x > nums[q] + nums[q - 1]) {
                        continue;
                    }
                    while (p < q) {
                        if (nums[p] + nums[q] < x) {
                            p++;
                        } else if (nums[p] + nums[q] > x) {
                            q--;
                        } else {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[p]);
                            temp.add(nums[q]);
                            result.add(temp);
                            p++;
                            q--;
                            while (p < q && nums[p - 1] == nums[p] && nums[q + 1] == nums[q]) {
                                p++;
                                q--;
                            }
                        }
                    }
                }
            }
            return result;
        }
    }
}
