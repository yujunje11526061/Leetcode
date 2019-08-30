package medium;

public class ContainerWithMostWater11 {

    class Solution {

        // 两端开始双指针。把短的那边往高的那边移，因为长板受短板制约，只有这样才有可能增大容积，反之则必然减小。
        public int maxArea(int[] height) {
            int i = 0;
            int j = height.length-1;
            int maxArea = 0;
            while(i<j){
                maxArea = Integer.max(maxArea, (j-i)*Integer.min(height[i],height[j]));
                if(height[i]<height[j]){
                    i++;
                }else{
                    j--;
                }
            }
            return maxArea;
        }
    }
}
