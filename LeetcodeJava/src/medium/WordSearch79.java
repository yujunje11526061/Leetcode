package medium;

public class WordSearch79 {

    class Solution {
        private boolean[][] visited;

        public boolean exist(char[][] board, String word) {
            if (board == null || board.length == 0) {
                return false;
            }
            if (word == null || word.length() == 0) {
                return false;
            }
            visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        boolean flag = dfs(i, j, board, word, 0);
                        if (flag) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private boolean dfs(int i, int j, char[][] board, String word, int p) {
            visited[i][j] = true;
            if (board[i][j] != word.charAt(p)) {
                visited[i][j] = false;
                return false;
            }else if(p==word.length()-1){
                return true;
            }
            if (i > 0 && !visited[i - 1][j] && dfs(i - 1, j, board, word, p + 1)) {
                return true;
            }
            if (i < board.length - 1 && !visited[i + 1][j] && dfs(i + 1, j, board, word, p + 1)) {
                return true;
            }
            if (j > 0 && !visited[i][j - 1] && dfs(i, j - 1, board, word, p + 1)) {
                return true;
            }
            if (j < board[0].length - 1 && !visited[i][j + 1] && dfs(i, j + 1, board, word, p + 1)) {
                return true;
            }
            visited[i][j] = false;
            return false;
        }
    }
}
