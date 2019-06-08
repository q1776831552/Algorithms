package dp;

import java.util.Arrays;

//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
public class LeetCode416 {
    private static int[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1)
            return false;

        sum /= 2;
        memo = new int[nums.length][sum + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        boolean result = tryPartition(nums, nums.length - 1, sum);
        return result;
    }

    private static boolean tryPartition(int[] nums, int index, int sum) {
        if (sum == 0)
            return true;

        if (sum < 0 || index < 0)
            return false;

        if (memo[index][sum] != -1)
            return memo[index][sum] == 1;

        memo[index][sum] = (tryPartition(nums, index - 1, sum) || tryPartition(nums, index - 1, sum - nums[index])) ? 1 : 0;
        return memo[index][sum] == 1;
    }

    boolean canPartition2(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if(sum % 2 == 1)
            return false;

        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        for(int i= 0; i < dp.length; i++)
            dp[i] = (nums[0] == i);

        for(int i = 1; i < nums.length; i++)
            for(int j = sum; j >= nums[i]; j--)
                dp[j] = dp[j] || dp[j - nums[i]];

        return dp[sum];

    }
}
