package dp;
/*现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
        你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。
        每个 0 和 1 至多被使用一次。*/

public class LeetCode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs.length == 0)
            return 0;

        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeros = 0, ones = 0;
            for(char c : str.toCharArray()) {
                if(c == '0')
                    zeros++;
                else
                    ones++;
            }

            for(int i = m; i >= zeros; i--)
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeros][j - ones]);
                }
        }
        return dp[m][n];
    }
}
