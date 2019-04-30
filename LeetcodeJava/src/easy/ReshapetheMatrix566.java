package easy;

import java.util.Arrays;

public class ReshapetheMatrix566 {
    public static ReshapetheMatrix566 instance = new ReshapetheMatrix566();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[][] nums = {{1,2},{3,4}};
        System.out.println(Arrays.deepToString(instance.solution.matrixReshape(nums, 1,4)));
    }

    class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            if(nums==null || nums.length==0){
                return nums;
            }
            int row = nums.length;
            int col = nums[0].length;
            int x = row*col;
            if(r*c!=x){
                return nums;
            }
            int cnt = 0;
            int[][] result = new int[r][c];
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    result[i][j] = nums[cnt/col][cnt%col];
                    cnt++;
                }
            }
            return result;
        }
    }
}
