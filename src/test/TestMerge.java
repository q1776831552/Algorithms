package test;

import java.util.Arrays;

public class TestMerge {
    public static void mergeSort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = (lo + hi) / 2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(int[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        int[] aux = new int[100];

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 8, 4, 2, 7, 6, 0, 3, 5};

        mergeSort(a, 0, a.length - 1);
        for (int item : a) {
            System.out.print(item + " ");
        }
    }

}
