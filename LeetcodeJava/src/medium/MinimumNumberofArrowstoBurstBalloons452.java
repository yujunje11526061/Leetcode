package medium;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberofArrowstoBurstBalloons452 {
    public static MinimumNumberofArrowstoBurstBalloons452 instance = new MinimumNumberofArrowstoBurstBalloons452();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int points[][] = {{10,16}, {2,8}, {1,6}, {7,12}};
        int result = instance.solution.findMinArrowShots(points);
        System.out.println(result);
    }


    class Solution {
        public int findMinArrowShots(int[][] points) {
            if(points==null || points.length==0){
                return 0;
            }
            if(points.length==1){
                return 1;
            }
            Arrays.sort(points, (int[] o1,int[] o2) -> o1[1]-o2[1]);
            int cnt=0;
            int prevEnd=0x80000000;
            for(int[] b: points){
                if(b[0]<=prevEnd){
                    continue;
                }
                prevEnd = b[1];
                cnt++;
            }
            return cnt;
        }
    }
}
