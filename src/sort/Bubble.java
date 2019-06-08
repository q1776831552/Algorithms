package sort;

public class Bubble {
    public static void main(String[] args) {
        int[] a = {3, 5, 1, 8, 4, 6};
        for (int i = a.length; i > 1; i--) {
            for (int j = 0; j < i - 1; j++){
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        for (int item : a) {
            System.out.print(item + " ");
        }
    }
}
