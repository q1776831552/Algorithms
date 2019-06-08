package zhenti;

import java.util.Scanner;

public class Jdong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String[] s = new String[m];
        for (int i = 0; i < m; i++) {
            s[i] = sc.next();
        }
        String target = sc.next();
        int n = target.length();
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
                int k = 0;
                for (int j = k + 1; j <= i; j++) {
                    if (isValid(target.substring(k, j), s)) {
                        dp[j] = Math.max(dp[k] + 1, dp[j]);
                    }
                    k++;
                }

        }

        System.out.println(dp[n]);
    }

    private static boolean isValid(String s, String[] strs) {
        for (String str : strs) {
            if(s.equals(str))
                return true;
        }
        return false;
    }
}
