package medium;

public class FindMinimuminRotatedSortedArray153 {
    public Solution solution = new Solution();

    public static void main(String[] args) {
        FindMinimuminRotatedSortedArray153 instance = new FindMinimuminRotatedSortedArray153();
        int[] nums = {4, 5};
        int result = instance.solution.findMin(nums);
        System.out.println(result);
    }

    class Solution {
        public int findMin(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums[0] < nums[nums.length - 1]) {
                return nums[0];
            }
            int i = 0, j = nums.length - 1;
            int mid;
            while (i <= j) {
                mid = (i + j) / 2;
                if (nums[mid] < nums[0]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
            return nums[i];
        }
    }
}

