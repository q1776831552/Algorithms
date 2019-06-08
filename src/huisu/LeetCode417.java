package huisu;

import java.util.ArrayList;
import java.util.List;

public class LeetCode417 {
    private int[][] d = {{1, 0}, {0 ,1}, {-1, 0}, {0 ,-1}};
    private int m, n;
    private List<int[]> res;

    public List<int[]> pacificAtlantic(int[][] matrix) {
        res = new ArrayList<>();
        m = matrix.length;
        if(m == 0)
            return null;
        n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, i, 0);
            dfs(matrix, atlantic, i,n - 1);
        }

        for (int i = 0; i < n; i++) {
            dfs(matrix, pacific, 0, i);
            dfs(matrix, atlantic,  m - 1, i);
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j])
                    res.add(new  int[]{i, j});
            }

         return res;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int startx, int starty) {
        visited[startx][starty] = true;

        for (int i = 0; i < 4; i++) {
            int newx = startx + d[i][0];
            int newy = starty + d[i][1];
            if (inArea(newx, newy) && !visited[newx][newy] && matrix[startx][starty] <= matrix[newx][newy]) {
                dfs(matrix, visited, newx, newy);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
