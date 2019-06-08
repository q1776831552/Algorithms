package shuzu;

public class LeetCode76 {
    public String minWindow(String s, String t) {
        int[] freq = new int[256];
        int cnt = t.length();
        int l = 0, r = 0;
        for (char c : t.toCharArray()) {
            freq[c]++;
        }
        String res = "";
        int minLen = s.length() + 1;

        while (r < s.length()) {
            if(freq[s.charAt(r++)]-- >= 1)
                cnt--;
            while (cnt == 0) {
                if(minLen > r - l)
                    res = s.substring(l, r);

                if(freq[s.charAt(l)] ++ >= 0)
                    cnt--;
                l++;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        String s = new LeetCode76().minWindow("a", "a");
        System.out.println(s);
    }
}
