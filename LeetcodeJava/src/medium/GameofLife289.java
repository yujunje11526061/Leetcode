package medium;

import java.util.Arrays;

public class GameofLife289 {
    public static GameofLife289 instance = new GameofLife289();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[][] board = {
            {1,1},
            {1,0},
//            {1,1,1},
//            {0,0,0}
        };
        instance.solution.gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }

    class Solution {
        public void gameOfLife(int[][] board) {
            if (board == null || board.length == 0) {
                return;
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    int cntOne = check(i, j, board);
                    if (board[i][j] == 1 && (cntOne < 2 || cntOne > 3)) {
                        board[i][j] = 2; // 死亡
                    } else if (board[i][j] == 0 && cntOne == 3) {
                        board[i][j] = 3; // 复活
                    }
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                   if(board[i][j]>1){
                       board[i][j] -= 2;
                   }
                }
            }
            return;
        }

        private int check(int i, int j, int[][] board) {
            int cnt = 0;
            if (i > 0) {
                if (j > 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 2)) {
                    cnt++;
                }
                if (board[i - 1][j] == 1 || board[i-1][j]==2) {
                    cnt++;
                }
                if (j + 1 < board[0].length && (board[i - 1][j + 1] == 1 || board[i - 1][j +1] == 2)) {
                    cnt++;
                }
            }
            if (j > 0 && (board[i][j - 1] == 1 || board[i][j - 1] == 2)) {
                cnt++;
            }
            if (j + 1 < board[0].length && (board[i][j + 1] == 1 || board[i][j + 1] == 2)) {
                cnt++;
            }
            if (i + 1 < board.length) {
                if (j > 0 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 2)) {
                    cnt++;
                }
                if (board[i + 1][j] == 1 || board[i + 1][j] == 2) {
                    cnt++;
                }
                if (j + 1 < board[0].length && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 2)) {
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
