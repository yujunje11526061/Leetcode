package medium;

import java.util.Arrays;

public class SpiralMatrix_II59 {
    public static SpiralMatrix_II59 instance = new SpiralMatrix_II59();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(instance.solution.generateMatrix(3)));
    }

    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            int l = 0, t = 0, r = n - 1, b = n - 1;
            int i = 0, j = 0;
            int cnt = 0;
            int tot = n * n;
            while (cnt < tot) {
                while (cnt < tot && j <= r) {
                    cnt++;
                    matrix[i][j] = cnt;
                    j++;
                }
                i++;
                j--;
                t++;
                while (cnt < tot && i <= b) {
                    cnt++;
                    matrix[i][j] = cnt;
                    i++;
                }
                i--;
                j--;
                r--;
                while (cnt < tot && j >= l) {
                    cnt++;
                    matrix[i][j] = cnt;
                    j--;
                }
                i--;
                j++;
                b--;
                while (cnt < tot && i >= t) {
                    cnt++;
                    matrix[i][j] = cnt;
                    i--;
                }
                j++;
                i++;
                l++;
            }
            return matrix;
        }
    }
}
