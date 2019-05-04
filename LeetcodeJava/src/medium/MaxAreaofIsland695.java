package medium;

public class MaxAreaofIsland695 {
    public static MaxAreaofIsland695 instance = new MaxAreaofIsland695();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(instance.solution.maxAreaOfIsland(grid));
    }

    class Solution {
        int cnt = 0;
        int tmpCnt = 0;
        public int maxAreaOfIsland(int[][] grid) {
            if(grid==null || grid.length==0){
                return 0;
            }
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]==1) {
                        tmpCnt = 0;
                        find(grid, i, j);
                    }
                }
            }
            return cnt;
        }

        private void find(int[][] grid, int i, int j) {
            grid[i][j] = 2;
            tmpCnt++;
            if(j+1<grid[0].length && grid[i][j+1]==1){
                find(grid, i,j+1);
            }
            if(i+1<grid.length&& grid[i+1][j]==1){
                find(grid, i+1,j);
            }
            if(i-1>=0 && grid[i-1][j]==1){
                find(grid, i-1,j);
            }
            if(j-1>=0&& grid[i][j-1]==1){
                find(grid, i,j-1);
            }
            cnt = Math.max(cnt, tmpCnt);
        }
    }

}
