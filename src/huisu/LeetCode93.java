package huisu;

import java.util.ArrayList;
import java.util.List;

public class LeetCode93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        restore(s, 4, "", res);
        return res;
    }

    public static void restore(String s, int k, String out, List<String> res) {
        if(k == 0) {
            if (s.length() == 0)
                res.add(out);
        }
        else {
            for(int i = 1; i <= 3; i++) {
                if(s.length() >= i && isValid(s.substring(0, 1))) {
                    if (k == 1)
                        restore(s.substring(i), k - 1, out + s.substring(0, i), res);
                    else
                        restore(s.substring(i), k - 1, out + s.substring(0, i) + ".", res);
                }
            }
        }
    }

    private static boolean isValid(String s) {
        if(s.length() > 1 && s.charAt(0) == '0')
            return false;
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}
