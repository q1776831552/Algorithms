package chazhaobiao;

import java.util.*;

public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
           char[] temp = str.toCharArray();
           Arrays.sort(temp);
           String s = String.valueOf(temp);
           if(!map.containsKey(s)) {
               map.put(s, new ArrayList<>());
           }
           map.get(s).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
