package chazhaobiao;

import java.util.*;

public class LeetCode451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            for(int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }

        return new String(sb);
    }

}
