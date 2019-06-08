package linkedList;

public class LeetCode5 {
    public String longestPalindrome(String s) {
        if(s.length() < 2)
            return  s;
        int start = 0, end = 0;

        for(int i = 0; i < s.length() - 1; i++) {
            int len1 = searchPalindrome(s, i, i);
            int len2 = searchPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int searchPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r - l - 1;
    }
}
