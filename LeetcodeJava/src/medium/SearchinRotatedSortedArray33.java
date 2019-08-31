package medium;

public class SearchinRotatedSortedArray33 {
    public static SearchinRotatedSortedArray33 instance =new SearchinRotatedSortedArray33();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {3};
        int target = 3;
        System.out.println(instance.solution.search(nums,target));
    }

    class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int topIndex = nums[0]<=nums[nums.length-1]?nums.length-1:findTop(nums);
            if (target >= nums[0]) {
                return findTarget(nums, target, 0, topIndex);
            } else {
                return findTarget(nums, target, topIndex + 1, nums.length - 1);
            }
        }

        private int findTarget(int[] nums, int target, int s, int e) {
            while (s <= e) {
                int mid = (s + e) / 2;
                if (nums[mid] <target){
                    s = mid+1;
                }else if(nums[mid]>target){
                    e = mid-1;
                }else{
                    return mid;
                }
            }
            return -1;
        }

        private int findTop(int[] nums) {
            int s = 0, e = nums.length - 1;
            while (s <= e) {
                int mid = (s + e) / 2;
                if (nums[mid] >= nums[0]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
            return e;
        }
    }
}
