package shuzu;

public class LeetCode125 {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1;

        while (l < r) {
            while (l < r && !isLetterOrDigit(arr[l]))
                l++;
            while (l < r && !isLetterOrDigit(arr[r]))
                r--;
            if(Character.toLowerCase(arr[l]) != Character.toLowerCase(arr[r]))
                return false;
            l++;
            r--;
        }
        return true;
    }

    private boolean isLetterOrDigit(char c) {
        if(c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
            return true;
        return false;
    }
}
