package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode51 {
    private List<List<String>> res;
    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        List<Integer> list = new ArrayList<>();
        putQueen(n, 0, list);
        return res;
    }

    private void putQueen(int n, int index, List<Integer> list) {
        if(index == n) {
            res.add(generateBoard(n, list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                list.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueen(n, index + 1, list);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    private List<String> generateBoard(int n, List<Integer> list) {
        List<String> board = new ArrayList<>();
        for(Integer colIndex : list) {
            char[] arr = new char[n];
            Arrays.fill(arr, '.');
            arr[colIndex] = 'Q';
            board.add(new String(arr));
        }
        return board;
    }

}
