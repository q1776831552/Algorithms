package sort;

import java.util.Scanner;

public class Selection {
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void sort(Comparable[] a) {
        int N = a.length;
        for(int min = 0; min < N; min++) {
            for (int j = min + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    exch(a, j , min);
                }
            }
        }
    }

    public static void show(Comparable[] a) {
        for(Comparable item : a){
            System.out.print(item + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] a = new String[5];

        int i = 0;
        while (scan.hasNext()) {
            a[i] = scan.next();
            i++;
        }
        show(a);
        sort(a);
        show(a);
    }
}
