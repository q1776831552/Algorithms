package chazhaobiao;

import java.util.HashMap;
import java.util.Map;

public class LeetCode149 {
    public int maxPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int duplicate = 0;
            Map<Map<Integer, Integer>, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                if(points[j][0] == points[i][0] && points[j][1] == points[i][1]) {
                    duplicate++;
                    continue;
                }

                Map<Integer, Integer> t = new HashMap<>();
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][0];
                int d = gcd(dx, dy);
                t.put(dx / d, dy/ d);
                map.put(t, map.getOrDefault(t, 0) + 1);
            }

            res = Math.max(res, duplicate);
            for (int value : map.values()) {
                res = Math.max(res, value);
            }
        }

        return res;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
