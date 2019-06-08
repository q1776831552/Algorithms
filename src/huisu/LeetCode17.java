package huisu;

import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {
    private static List<String> res = new ArrayList<>();
    private static String[] strs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        findCombination(digits, 0, "");
        return res;
    }

    private static void findCombination(String digits, int index, String s) {
        if(index == digits.length()) {
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        for(char item : strs[c - '2'].toCharArray()) {
            findCombination(digits, index + 1, s + item);
        }
    }

    public static void main(String[] args) {
        int[] a = {3,3,0,3};
        System.out.println(new LeetCode47().permuteUnique(a));
    }
}
