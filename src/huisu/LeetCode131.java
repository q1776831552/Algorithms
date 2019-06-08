package huisu;

import javax.sound.midi.Soundbank;
import java.util.*;

public class LeetCode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> out = new ArrayList<>();
        partion(s, 0, out, res);
        return res;
    }

    private static void partion(String s, int start, List<String> out, List<List<String>> res) {
        if(start == s.length()) {
            res.add(new ArrayList<>(out));
            return;
        }

        for(int i = start; i < s.length(); i++) {
            if(!isPalindrome(s.substring(start, i + 1))) continue;
            out.add(s.substring(start, i + 1));
            partion(s, i + 1, out, res);
            out.remove(out.size() - 1);
        }
    }

    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
