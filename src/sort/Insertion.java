package sort;

import java.util.Scanner;

public class Insertion {
    private static void sort(int[] s) {
        int temp ;
        for (int i = 1; i < s.length; i++) {
            temp = s[i];
            int j;
            for ( j= i - 1; j >= 0 ;j--) {
                if (temp < s[j]) {
                    s[j+1] = s[j];
                } else {
                    break;
                }
            }
            s[j+1] = temp;
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(int[] a) {
        for(Comparable item : a){
            System.out.print(item + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] s = new int[5];
        int i = 0;
        while (scan.hasNextInt()) {
            s[i] = scan.nextInt();
            i++;
        }
        sort(s);
        show(s);
    }
}
