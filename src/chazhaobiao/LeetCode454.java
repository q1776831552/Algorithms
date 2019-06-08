package chazhaobiao;

import java.util.HashMap;
import java.util.Map;

public class LeetCode454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < B.length; j++) {
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
            }

        int res = 0;
        for (int i = 0; i < C.length; i++)
            for (int j = 0; j < D.length; j++) {
                int target = 0 - C[i] - D[j];
                if(map.get(target) != null) {
                    res += map.get(target);
                }
            }

        return res;
    }
}
