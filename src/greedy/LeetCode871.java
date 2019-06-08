package greedy;

import java.util.PriorityQueue;

public class LeetCode871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int cur = startFuel, i = 0, cnt = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        while(true) {
            if (cur >= target)
                return cnt;

            while (i < stations.length && cur >= stations[i][0])
                maxHeap.offer(stations[i][1]);

            if(maxHeap.isEmpty())
                return  -1;

            cur += maxHeap.poll();
            cnt++;
        }
    }
}
