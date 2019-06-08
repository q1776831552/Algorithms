package test;

public class TestInsert {
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (temp < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 8, 4, 2, 7, 6, 0};

        insertionSort(a);

        for (int item : a) {
            System.out.print(item + " ");
        }
    }
}
