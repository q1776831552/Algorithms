package dp;

public class LeetCode213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n <= 1)
            return n == 0 ? 0 : nums[0];

        return Math.max(rob(nums, 0, n), rob(nums, 1, n + 1));
    }

    private int rob(int[] nums, int l, int r) {
        if(l + 1 == r)
            return nums[l];

        int res = 0;
        int[] dp = new int[r];
        dp[l] = nums[l];
        dp[l + 1] = Math.max(nums[l], nums[l + 1]);
        for (int i = l + 2; i < r; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return res;
    }
}
