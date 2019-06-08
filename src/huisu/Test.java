package huisu;

import com.sun.org.apache.bcel.internal.generic.SWAP;
import linkedList.ListNode;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Test {
    private static String[] strs;
    private List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        StringBuffer str = new StringBuffer();
        findLetter(digits, 0, str);
        return res;
    }

    private void findLetter(String digits, int index, StringBuffer s) {
        if(index == digits.length())
            return;

        for (int i = 0; i < 3; i++) {
            s.append(strs[digits.charAt(index) - '2'].charAt(i));
            findLetter(digits, index + 1, s);
        }
    }


    public static void main(String[] args) {
        List<Object> list  = new ArrayList<>(10);
        for (int i = 0; i <100; i++) {
            Object o = new Object();
            list.add(o);
            o = null;
        }
        System.out.println(list);
    }

    private void swap(int m, int n) {
        int temp = m;
        m = n;
        n = temp;
    }
}
