package medium;

import java.util.Arrays;

public class SmallestRangeII910 {
    public static SmallestRangeII910 instance = new SmallestRangeII910();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] A = {8038, 9111, 5458, 8483, 5052, 9161, 8368, 2094, 8366, 9164, 53, 7222, 9284, 5059, 4375, 2667, 2243, 5329, 3111, 5678, 5958, 815, 6841, 1377, 2752, 8569, 1483, 9191, 4675, 6230, 1169, 9833, 5366, 502, 1591, 5113, 2706, 8515, 3710, 7272, 1596, 5114, 3620, 2911, 8378, 8012, 4586, 9610, 8361, 1646, 2025, 1323, 5176, 1832, 7321, 1900, 1926, 5518, 8801, 679, 3368, 2086, 7486, 575, 9221, 2993, 421, 1202, 1845, 9767, 4533, 1505, 820, 967, 2811, 5603, 574, 6920, 5493, 9490, 9303, 4648, 281, 2947, 4117, 2848, 7395, 930, 1023, 1439, 8045, 5161, 2315, 5705, 7596, 5854, 1835, 6591, 2553, 8628};
        int K = 4643;
        System.out.println(instance.solution.smallestRangeII(A, K));
    }

    class Solution {
        // 对A排序，则一定是在某个隔板两侧操作相反，前半部分都+K，后半部分都-K。
        // 那么最大一定在前半部分的尾巴和后半部分的尾巴产生，最小一定在前半部分的头和后半部分的头产生。
        // 故只要对隔板位置遍历就好。
        public int smallestRangeII(int[] A, int K) {
            Arrays.sort(A);
            int result = A[A.length-1]-A[0];
            for(int i=1;i<A.length;i++){
                int max=Math.max(A[i-1]+K,A[A.length-1]-K);
                int min=Math.min(A[0]+K,A[i]-K);
                result = Math.min(max-min,result);
            }
            return  result;
        }
    }
}
