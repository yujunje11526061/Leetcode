package hard;


import java.util.ArrayDeque;
import java.util.Arrays;

public class SlidingWindowMaximum239 {
    public static SlidingWindowMaximum239 instance = new SlidingWindowMaximum239();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = instance.solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length < k || nums.length==0) {
                return new int[0];
            } else {
                int[] result = new int[nums.length-k+1];
                ArrayDeque<Integer> dq = new ArrayDeque<>(k);
                for(int i=0,j=0;i<nums.length;i++){
                    while(!dq.isEmpty() && nums[dq.getLast()]<=nums[i]){
                        dq.removeLast();
                    }
                    dq.add(i);
                    if(dq.getFirst()<=i-k){
                        dq.removeFirst();
                    }
                    if(i>=k-1){
                        result[j] = nums[dq.getFirst()];
                        j++;
                    }
                }
                return result;
            }
        }
    }
}
