package easy;

public class LargestNumberAtLeastTwiceofOthers747 {
    public static LargestNumberAtLeastTwiceofOthers747 instance = new LargestNumberAtLeastTwiceofOthers747();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.dominantIndex(new int[]{2,3,4,0,1,8}));
    }

    class Solution {
        public int dominantIndex(int[] nums) {
            if(nums==null || nums.length==0){
                return -1;
            }
            if(nums.length==1){
                return 0;
            }
            int first=0x80000000;
            int second=0x80000000;
            int x=-1,y=-1;
            for(int i=0;i<nums.length;i++){
                if(nums[i]>=first){
                    second=first;
                    first=nums[i];
                    y=x;
                    x=i;
                }else if(nums[i]>=second){
                    second=nums[i];
                    y=i;
                }
            }
            if(first>=second*2){
                return x;
            }
            return -1;
        }
    }
}
