package sort;

import java.util.Scanner;

public class Shell {
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (Comparable item : a) {
            System.out.print(item + " ");
        }
    }

    public static void sort(Comparable[] a) {
        int h = 1;
        while (h < a.length/3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && a[j].compareTo(a[j - h]) < 0; j -= h) {
                    exch(a, j, j - h);
                }

            }
            h = h / 3;

        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] s = new String[10];
        int i = 0;
        while (scan.hasNext()) {
            s[i] = scan.next();
            i++;
        }
        sort(s);
        show(s);
    }
}
