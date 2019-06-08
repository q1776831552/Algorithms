package shuzu;

public class LeetCode75 {
    public void sortColors(int[] nums) {
        int zero = -1;
        int two = nums.length;

        for (int i = 0; i < two;) {
            if(nums[i] == 0)
                swap(nums, ++zero, i);
            else if(nums[i] == 1)
                i++;
            else
                swap(nums, i, --two);
        }
    }

    public void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
