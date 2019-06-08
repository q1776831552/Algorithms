package shuzu;

public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                if(i != k)
                    swap(nums, k, i);
                k++;
            }
        }
    }

    public void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
