package easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray448 {
    public static FindAllNumbersDisappearedinanArray448 instance = new FindAllNumbersDisappearedinanArray448();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(instance.solution.findDisappearedNumbers(nums));
    }

    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for(int i=0;i<nums.length;i++){
                while(nums[i]!=i+1 && nums[nums[i]-1]!=nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[temp-1];
                    nums[temp-1] = temp;
                }
            }
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=i+1){
                    list.add(i+1);
                }
            }
            return list;
        }
    }
}
