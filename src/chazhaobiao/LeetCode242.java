package chazhaobiao;

import java.util.HashMap;
import java.util.Map;

public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            Integer count = map.get(c);
            if(count == null)
                return false;
            else if(count > 1)
                map.put(c, count - 1);
            else
                map.remove(c);
        }

        return map.isEmpty();
    }
}
