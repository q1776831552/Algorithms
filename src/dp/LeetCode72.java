package dp;
/*给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

        你可以对一个单词进行如下三种操作：

        插入一个字符
        删除一个字符
        替换一个字符*/

public class LeetCode72 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];

        for(int i = 0, j =  0; i < len1 + 1; i++)
            dp[i][j] = i;

        for(int i = 0, j = 0; j < len2 + 1; j++)
            dp[i][j] = j;

        for(int i = 1; i <= len1; i++)
            for(int j = 1; j <= len2; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) +1;
            }

        return dp[len1][len2];
    }
}
