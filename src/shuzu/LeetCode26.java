package shuzu;

public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return  0;
        int c = 0;
        for (int num : nums) {
            if(nums[c] != num) {
                nums[++c] = num;
            }
        }
        return c + 1;
    }
}
