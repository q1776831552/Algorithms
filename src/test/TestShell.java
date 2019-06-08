package test;

public class TestShell {
    public static void sort(int[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                int j = i, e = a[i];
                for (; j >= h && e < a[j-h]; j -= h) {
                        a[j] = a[j - h];
                    }
                    a[j] = e;
                }
            h = h / 3;
            }

}



    public static void main(String[] args) {
        int[] a = {1, 8, 4, 2, 7, 6, 0, 3, 5};

        sort(a);
        for (int item : a) {
            System.out.print(item + " ");
        }
    }
}
