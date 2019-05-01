package medium;

import java.util.Arrays;

public class RotateImage48 {
    public static RotateImage48 instance = new RotateImage48();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        instance.solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    class Solution {
        public void rotate(int[][] matrix) {
            //先转置再对称变换
            for(int i=0;i<matrix.length;i++){
                for(int j=i+1;j<matrix.length;j++){
                    int x = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = x;
                }
            }
            for(int i=0;i<matrix.length;i++){
                int p=0,q = matrix.length-1;
                while(p<q){
                    int x = matrix[i][p];
                    matrix[i][p] = matrix[i][q];
                    matrix[i][q] = x;
                    p++;
                    q--;
                }
            }
        }
    }
}
