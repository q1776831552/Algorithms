package sort;

import java.util.Scanner;

public class Quick {
    public static int  partion(Comparable[] a, int lo, int hi) {
        int i = lo + 1, j = hi;
        Comparable v = a[lo];

        while (true) {
            while (a[i].compareTo(v) <= 0) i++;
            while (a[j].compareTo(v) >= 0) j--;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return  j;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        
        if (hi <= lo) return;
        int j = partion(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private  static void show(Comparable[] a) {
        for (Comparable item : a) {
            System.out.print(item + " ");
        }
    }

    public static void main(String[] args) {
        Integer [] s = {6, 3, 2, 3, 3, 1, 3};

        sort(s);
        show(s);
    }
}
