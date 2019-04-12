package medium;

public class BattleshipsinaBoard419 {
    public static BattleshipsinaBoard419 instance = new BattleshipsinaBoard419();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        char[][] board = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        System.out.println(instance.solution.countBattleships(board));
    }

    class Solution {
        public int countBattleships(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) {
                return 0;
            }
            int row = board.length;
            int colomn = board[0].length;
            int cnt = 0;
            for (int i = 0; i < row; i++) {
                boolean flag=false;
                for (int j = 0; j < colomn; j++) {
                    if (board[i][j] == 'X' && !flag && (i - 1 < 0 || board[i - 1][j] != 'X')) {
                        cnt++;
                        flag = true;
                    }else if(board[i][j]=='.' && flag==true){
                        flag = false;
                    }
                }
            }
            return cnt;
        }
    }
}
