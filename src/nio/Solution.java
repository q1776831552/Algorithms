package nio;

public class Solution {
    public String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        int blank = -1;
        reverse(chars, 0, chars.length - 1);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                int nextBlank = i;
                reverse(chars, blank + 1, nextBlank - 1);
                blank = nextBlank;
            }
            reverse(chars, blank + 1, chars.length - 1);
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().ReverseSentence("i am a student."));
        long i = 1, k = 2;
        int j = (int) (i * k);

    }
}