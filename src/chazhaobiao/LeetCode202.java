package chazhaobiao;

import java.util.HashSet;
import java.util.Set;

public class LeetCode202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            n = sum;
            if(set.contains(n))
                break;
            set.add(n);
        }

        return  n == 1;
    }
}
