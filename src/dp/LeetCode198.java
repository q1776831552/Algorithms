package dp;

public class LeetCode198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n <= 1)
            return n == 0 ? 0 : nums[0];

        int[] memo = new int[n];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            memo[i] = Math.max(memo[i - 1], nums[i] + memo[i - 2]);
        }

        return memo[n - 1];
    }
}
