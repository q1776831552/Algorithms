package chazhaobiao;

import java.util.HashSet;
import java.util.Set;

public class LeetCode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> record = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums1) {
            record.add(num);
        }

        for(int num : nums2) {
            if(record.contains(num)) {
                resultSet.add(num);
            }
        }

        int[] res = new int[resultSet.size()];
        int i = 0;
        for (int item : resultSet) {
            res[i++] = item;
        }

        return res;
}
}
