package easy;

public class RemoveElement27 {

    class Solution {
        public int removeElement(int[] nums, int val) {
            if(nums.length==0){
                return 0;
            }
            int begin = -1;
            int end = -1;
            for (int i = 0; i <nums.length ; i++) {
                if(nums[i]==val){
                    if(end<0){
                        begin = end = i;
                    }else{
                        end++;
                    }
                }else if(begin>=0){
                    nums[begin] = nums[i];
                    begin++;
                    end++;
                }
            }
            return begin>=0?begin:nums.length;
        }
    }
}
