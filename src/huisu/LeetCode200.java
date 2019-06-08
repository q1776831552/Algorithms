package huisu;

import javax.swing.*;

public class LeetCode200 {
    private int[][] d = {{1, 0}, {0 ,1}, {-1, 0}, {0 ,-1}};
    private boolean[][] visited;
    private int m, n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        if(m == 0)
            return 0;

        n = grid[0].length;
        int res = 0;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }

        return res;
    }

    private void dfs(char[][] grid, int startx, int starty) {
        visited[startx][starty] = true;

        for (int i = 0; i < 4; i++) {
            int newx = startx + d[i][0];
            int newy = starty + d[i][1];
            if (inArea(newx, newy) && !visited[newx][newy] && grid[newx][newy] == '1') {
                dfs(grid, newx, newy);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
