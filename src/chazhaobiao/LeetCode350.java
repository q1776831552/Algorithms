package chazhaobiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> record = new HashMap<>();

        for (int num : nums1) {
            Integer count = record.get(num);
            if(count == null)
                record.put(num, 1);
            else
                record.put(num, ++count);
        }

        List<Integer> list = new ArrayList<>();
        for(int num : nums2) {
            Integer count = record.get(num);
            if(count != null && count != 0){
                list.add(num);
                record.put(num, --count);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] interse(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            Integer count = map.get(num);
            if(count != null && count > 0) {
                list.add(num);
                map.put(num, --count);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
