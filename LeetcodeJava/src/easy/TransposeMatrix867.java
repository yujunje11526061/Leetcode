package easy;

import java.util.Arrays;

public class TransposeMatrix867 {
    public static TransposeMatrix867 instance = new TransposeMatrix867();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] result = instance.solution.transpose(A);
        System.out.println(Arrays.deepToString(result));
    }

    class Solution {
        public int[][] transpose(int[][] A) {
            if(A==null || A.length==0 || A[0].length==0){
                return null;
            }
            int row = A.length;
            int column = A[0].length;
            int[][] result = new int[column][row];
            for(int i=0;i<column;i++){
                for(int j=0;j<row;j++){
                    result[i][j] = A[j][i];
                }
            }
            return result;
        }
    }
}
