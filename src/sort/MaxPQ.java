package sort;

public class MaxPQ {

    private static int N = 0;
    private static int[] a = new int[10];
    private static void swim(int k) {
        while (k > 1 && a[k] > a[k/2]) {
            exch(a, k, k/2);
            k = k / 2;
        }
    }

    private static void sink(int k) {
        while (2*k <= N) {
            int j = 2 * k;
            if (j < N && a[j] < a[j+1]) j++;
            if (a[k] > a[j]) break;
            exch(a, k, j);
            k = j;
        }
    }

    private static void insert(int v) {
        a[++N] = v;
        swim(N);

    }

    private static int delMax() {
        int max = a[1];
        a[1] = a[N];
        a[N--] = 0;
        sink(1);
        return max;
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(int[] a) {
        for(int item : a){
            System.out.print(item + " ");
        }
    }

    public static void main(String[] args) {
        insert(8);
        insert(3);
        insert(9);
        insert(11);
        insert(1);
        insert(31);
        show(a);
        System.out.println(delMax());
        show(a);
    }
}
