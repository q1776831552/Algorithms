package sort;

public class HeapSort {
    private static int[] maxHeap = new int[10];
    private static int count = 0;

    private static void swap(int i, int j) {
        int temp = maxHeap[i];
        maxHeap[i] = maxHeap[j];
        maxHeap[j] = temp;
    }

    private static void swim(int k) {
        while (k > 1 && maxHeap[k] > maxHeap[k/2]) {
            swap(k, k/2);
            k /= 2;
        }
    }

    private static void sink(int k) {

        while (2 * k <= count) {
            int j = 2 * k;
            if (j+1 <= count && maxHeap[j] < maxHeap[j+1]) {
                j++;
            }

            if (maxHeap[k] >= maxHeap[j]) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private static void insert(int value) {
        maxHeap[++count] = value;
        swim(count);
    }

    private static int delMax() {
        int result = maxHeap[1];
        swap(1, count);
        count--;
        sink(1);
        return result;
    }

    public static void sort(int[] a) {
        for (int item : a) {
            insert(item);
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = delMax();
        }
    }

    public static void main(String[] args) {
        int[] a = {6, 2, 9, 4, 1, 7, 3};
        sort(a);
        for (int item : a)  {
            System.out.print(item + " ");
        }
    }
}
