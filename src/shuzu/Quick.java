package shuzu;

public class Quick {
    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int l, int r) {
        if(l >= r)
            return;

        int p = partition(nums, l, r);
        quickSort(nums, l, p - 1);
        quickSort(nums, p + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int v = nums[l];
        //[l+1, j] < v   [j + 1, r] > v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if(nums[i] < v)
                swap(nums, ++j, i);
        }
        swap(nums, l, j);
        return j;
    }

    //三路快排nums[l, lt - 1] < v, nums[lt, gt - 1] == v, nums[gt, r] > v


    public void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {6, 4, 7, 3, 1, 3, 2};
        new Quick().quickSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
