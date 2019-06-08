package shuzu;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Util {

    static int main(int n, int[] balls) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            count.put(balls[i], count.getOrDefault(balls[i], 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        for (int value : count.values()) {
            min = Math.min(min, value);
        }

        if(min == 1)
            return 0;

        int res = 0;
        for (int value : count.values()) {
            if(value % min != 0)
                return 0;
            res += value / min;
        }

        return res;
    }
    

    public static void main(String[] args) {
        int[] a = new int[10];
        int i = 1;
        a[i++]++;
        System.out.println(a[2]);
    }
}
