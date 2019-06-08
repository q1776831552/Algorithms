package zhenti;

import java.util.Arrays;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int w = in.nextInt();
        int[] boy = new int[n];
        int[] girl = new int[n];
        for (int i = 0; i < n; i++)
            boy[i] = in.nextInt();

        for (int i = 0; i < n; i++)
            girl[i] = in.nextInt();

        Arrays.sort(boy);
        Arrays.sort(girl);
        double result = 0;
        if(boy[0] >= 2 * girl[0]) {
            result = girl[0] * 3 * n;
        } else {
            result = boy[0] * 1.5 * n;
        }

        if(w < result) {
            result = w;
        }

        System.out.printf("%.6f", result);
    }
}
