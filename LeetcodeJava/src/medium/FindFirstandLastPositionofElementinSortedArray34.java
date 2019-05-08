package medium;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray34 {
    public static FindFirstandLastPositionofElementinSortedArray34 instance= new FindFirstandLastPositionofElementinSortedArray34();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 12;
        System.out.println(Arrays.toString(instance.solution.searchRange(nums,target)));
    }


    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result = {-1,-1};
            result[0] = findFirst(nums, target);
            if(result[0]==-1){
                return result;
            }
            result[1] = findLast(nums, target);
            return  result;
        }

        private int findLast(int[] nums, int target) {
            int s=0,e=nums.length-1;
            while(s<=e){
                int mid= (s+e)/2;
                if(target>=nums[mid]){
                    s = mid+1;
                }else{
                    e = mid-1;
                }
            }
            if(e>=0&&nums[e]==target){
                return e;
            }else{
                return -1;
            }
        }

        private int findFirst(int[] nums, int target) {
            int s = 0, e = nums.length-1;
            while(s<=e){
                int mid = (s+e)/2;
                if(target<=nums[mid]){
                    e = mid-1;
                }else{
                    s = mid+1;
                }
            }
            if(s<=nums.length-1&&nums[s]==target){
                return s;
            }else{
                return -1;
            }
        }
    }
}
