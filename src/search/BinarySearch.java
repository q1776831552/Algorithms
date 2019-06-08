package search;

public class BinarySearch {

    private static int search(int key) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int low = 0, high = a.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key == a[mid]) {
              return mid;
            } else if (key> a[mid]) {
                low = mid + 1;

            } else {
                high = mid - 1;
            }


        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(4));
    }
}

