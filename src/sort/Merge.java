package sort;

import java.util.Scanner;

public class Merge {
    private static Comparable[] aux;
    public static void merge(Comparable[] a, int lo, int mid, int hi) {

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[i].compareTo(aux[j]) < 0) a[k] = aux[i++];
            else a[k] = aux[j++];
        }

    }

        private static void sort(Comparable[] a) {
            aux = new Comparable[a.length];
            sort(a, 0, a.length - 1);
        }

        private static void sortBu(Comparable[] a) {
            aux = new Comparable[a.length];
            for (int sz = 1; sz < a.length; sz += sz) {
                for (int i = 0; i < a.length - sz ; i = i + sz * 2) {
                    merge(a, i, i + sz -1,Math.min(i + 2 * sz -1, a.length - 1));
                }
            }
        }

        private static void sort(Comparable[] a, int lo, int hi) {
            if(hi <= lo) return;
            int mid = (lo + hi)/2;

            sort(a, lo, mid);
            sort(a, mid + 1, hi);
            merge(a, lo, mid, hi);
        }

    private  static void show(Comparable[] a) {
        for (Comparable item : a) {
            System.out.print(item + " ");
        }
    }

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            String[] s = new String[6];
            int i = 0;
            while (scan.hasNext()) {
                s[i] = scan.next();
                i++;
            }

            sortBu(s);
            show(s);
        }

}
