package test;

public class QuickSort {
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void sort(int a[], int start, int end) {
        int lo = start;
        int hi = end;
        int key = a[lo];
        while (lo < hi) {
            while (lo < hi && a[hi] >= key) {
                hi--;
            }

                swap(a, lo, hi);

            while (lo < hi && a[lo] <= key) {
                lo++;
            }

                swap(a, lo, hi);


        }

        if (start < lo) sort(a, start, lo-1);
        if (hi < end) sort(a, hi+1, end);

    }

    public static void main(String[] args) {
        int[] a = {4,2,5,7,1,3};
        sort(a, 0, a.length-1
        );
        for (int item : a) {
            System.out.print(item + " ");
        }
    }
}
