package chazhaobiao;

import java.util.HashMap;
import java.util.Map;

public class LeetCode290 {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        int len1 = pattern.length(), len2 = strs.length;
        if(len1 != len2)
            return false;

        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            char c = pattern.charAt(i);
            String s = strs[i];
            if(map.containsKey(c)) {
                if(!map.get(c).equals(s)) {
                    return false;
                }
            } else {
                if(map.containsValue(s)) {
                    return false;
                } else {
                    map.put(c, s);
                }
            }
        }

        return true;
    }
}
