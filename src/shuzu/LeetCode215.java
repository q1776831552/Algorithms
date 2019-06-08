package shuzu;

public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        if(r == 0)
            return nums[0];
        while (true) {
            int pos = partion(nums, l, r);
            if(pos == k - 1)
                return nums[pos];
            else if(pos > k - 1)
                r = pos - 1;
            else
                l = pos + 1;
        }

    }

    private int partion(int[] nums, int l, int r) {
        int v = nums[l];
        int i = l, j = r + 1;
        while (true) {
            while(nums[++i] > v)
                if(i == r)
                    break;
            while(nums[--j] < v);

            if(i >= j)
                break;
            swap(nums, i++, j--);
        }

        swap(nums, l, j);
        return j;
    }

    public void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1};
        int res = new LeetCode215().findKthLargest(nums, 2);
        System.out.println(res);
    }
}
