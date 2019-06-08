package dp;

import java.util.Arrays;

public class LeetCode376 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;

        int[] dp = new int[n];
        int[] flag = new int[n]; //0表示可升可降，1表示必须升，2表示必须降
        Arrays.fill(dp, 1);

        for(int i = 1; i < n; i++)
            for(int j = 0; j < i; j++) {
                if(flag[j] == 0) {
                    if(nums[i] > nums[j]) {
                        dp[i] = dp[j] + 1;
                        flag[i] = 2;
                    } else if(nums[i] < nums[j]){
                        dp[i] = dp[j] + 1;
                        flag[i] = 1;
                    }
                } else if(flag[j] == 1 && nums[i] > nums[j]) {
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        flag[i] = 2;
                    }
                } else if(flag[j] == 2 && nums[i] < nums[j]){
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        flag[i] = 1;
                    }
                }
            }

        Arrays.sort(dp);
        return dp[n - 1];
    }
}
