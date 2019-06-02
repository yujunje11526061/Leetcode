package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin973 {
    public static KClosestPointstoOrigin973 instance = new KClosestPointstoOrigin973();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int K = 2;
        System.out.println(Arrays.deepToString(instance.solution.kClosest(points,K)));
    }

    // TopN问题
    // 堆或者快排思想。
    class Solution {
        public int[][] kClosest(int[][] points, int K) {
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                    (o1, o2) -> -Integer.compare(o1[0]*o1[0]+o1[1]*o1[1],o2[0]*o2[0]+o2[1]*o2[1]));
            for(int[] point:points){
                if(priorityQueue.size()<K){
                    priorityQueue.offer(point);
                }else{
                    int[] top = priorityQueue.peek();
                    if(top[0]*top[0]+top[1]*top[1]>point[0]*point[0]+point[1]*point[1]){
                        priorityQueue.poll();
                        priorityQueue.offer(point);
                    }
                }
            }
            int[][] result = new int[K][2];
            int i=0;
            for(int[] pair:priorityQueue){
                result[i] = pair;
                i++;
            }
            return result;
        }
    }
}
