package dp;

import javax.sound.midi.Soundbank;

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
// 如果没有任何一种硬币组合能组成总金额，返回 -1。
public class LeetCode322 {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length && i >= coins[j]; j++) {
                dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
            }
        }
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] a = {2};
        int ret = coinChange(a, 3);
        System.out.println(ret);
    }
}
