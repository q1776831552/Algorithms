package shuzu;

import javax.print.attribute.standard.RequestingUserName;
import java.util.ArrayList;
import java.util.List;

public class LeetCode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int l = 0, r = 0;
        int[] freq = new int[26];
        int cnt = p.length();
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        while (r < s.length()) {
            if(freq[s.charAt(r++) - 'a']-- >= 1)
                cnt--;
            if(cnt == 0)
                res.add(l);
            if(r - l == p.length()) {

                if(freq[s.charAt(l) - 'a'] >= 0) {
                    cnt++;
                }
                freq[s.charAt(l) - 'a']++;
                l++;
            }

        }

        return res;
    }
}

