package search;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] strs = new String[n];
        String[] subStr = new String[m];
        int[] res = new int[m];

        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }

        for (int i = 0; i < m; i++) {
            subStr[i] = sc.next();
        }

        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (String str : strs) {
                if(str.contains(subStr[i])) {
                    cnt++;
                }
            }

            res[i] = cnt;
        }

        for (int item : res) {
            System.out.println(item);
        }
    }
}
