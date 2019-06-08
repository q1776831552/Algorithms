package huisu;

public class LeetCode130 {
    private int[][] d = {{1, 0}, {0 ,1}, {-1, 0}, {0 ,-1}};
    private int m, n;

    public void solve(char[][] board) {
        m = board.length;
        if(m == 0)
            return;
        n = board[0].length;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if(i == 0 || i == m - 1 || j ==0 || j == n - 1 && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }

         for (int i = 0; i < m; i++)
             for (int j = 0; j < n; j++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '$')
                    board[i][j] = 'O';
             }

    }

    private void dfs(char[][] board, int startx, int starty) {
        board[startx][starty] = '$';

        for (int i = 0; i < 4; i++) {
            int newx = startx + d[i][0];
            int newy = starty + d[i][1];
            if(inArea(newx, newy) && board[newx][newy] == 'O') {
                dfs(board, newx, newy);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
