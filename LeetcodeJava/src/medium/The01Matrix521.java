package medium;

import java.util.Arrays;

public class The01Matrix521 {
    public static The01Matrix521 instance = new The01Matrix521();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[][] matrix = {  {0,0,0},
                            {0,1,0},
                            {1,2,1}};
        System.out.println(Arrays.deepToString(instance.solution.updateMatrix(matrix)));
    }

    class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            if(matrix==null||matrix.length==0){
                return null;
            }
            int[][] result = new int[matrix.length][matrix[0].length];
            for(int i=0; i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    if(matrix[i][j]==0){
                        result[i][j]=0;
                    }else {
                        setValue(i, j, result);
                    }
                }
            }
            for(int i=matrix.length-1; i>=0;i--){
                for(int j=matrix[0].length-1; j>=0;j--){
                    if(result[i][j]>0){
                        setValue2(i,j,result);
                    }
                }
            }
            return result;
        }

        private void setValue2(int i, int j, int[][] result) {
            if(i+1<result.length){
                result[i][j]=result[i][j]<result[i+1][j]+1?result[i][j]:result[i+1][j]+1;
            }
            if(j+1<result[0].length){
                result[i][j] = result[i][j]<result[i][j+1]+1?result[i][j]:result[i][j+1]+1;
            }
        }

        private void setValue(int i, int j, int[][] result) {
            result[i][j]=0x7fffffff;
            if(i-1>=0&&result[i-1][j]!=0x7fffffff){
                result[i][j]=result[i-1][j]+1;
            }
            if(j-1>=0&&result[i][j-1]!=0x7fffffff){
                result[i][j] = result[i][j]<result[i][j-1]+1?result[i][j]:result[i][j-1]+1;
            }
        }
    }

}
