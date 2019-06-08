package dp;

import java.util.Arrays;
//给定一个无序的整数数组，找到其中最长上升子序列的长度。

public class LeetCode300 {
    public int lengthOfLIS(int[] nums)  {
        int n = nums.length;
        if(n == 0)
            return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 1; i < n; i++)
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }

        Arrays.sort(dp);
        return dp[n - 1];
    }
}
