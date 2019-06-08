package chazhaobiao;

import java.util.HashMap;
import java.util.Map;

public class LeetCode447 {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if(j != i)
                    map.put(dist(points[i], points[j]), map.getOrDefault(dist(points[i], points[j]), 0) + 1);
            }

            for (int value : map.values()) {
                res += value * (value - 1);
            }
        }

        return res;
    }

    private int dist(int[] a, int[] b) {
        return (b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]);
    }
}
