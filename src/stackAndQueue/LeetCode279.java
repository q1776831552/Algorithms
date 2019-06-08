package stackAndQueue;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LeetCode279 {
    public int numSquares(int n) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{n, 0});
        boolean[] visited = new boolean[n];
        visited[n] = true;

        while (!q.isEmpty()) {
            int num = q.peek()[0];
            int step = q.peek()[1];
            q.poll();

            if(num == 0)
                return step;
            for (int i = 1; i < num - i * i; i++) {
                if(!visited[num - i * i]) {
                    q.offer(new int[]{num - i * i, step + 1});
                    visited[num - i * i] = true;
                }
            }
        }

        return 0;
    }
}
