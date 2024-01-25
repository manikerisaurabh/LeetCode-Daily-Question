/*
====================================================== 1143. Longest Common Subsequence    ======================================================


Problem Statement : Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

                    A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

                    For example, "ace" is a subsequence of "abcde".
                    A common subsequence of two strings is a subsequence that is common to both strings.


Examples : 

                Example 1:
                Input: text1 = "abcde", text2 = "ace" 
                Output: 3  
                Explanation: The longest common subsequence is "ace" and its length is 3.

                Example 2:
                Input: text1 = "abc", text2 = "abc"
                Output: 3
                Explanation: The longest common subsequence is "abc" and its length is 3.

                Example 3:
                Input: text1 = "abc", text2 = "def"
                Output: 0
                Explanation: There is no such common subsequence, so the result is 0.
*/






public class 25-Jan {
    public int longestCommonSubsequence(String text1, String text2) {
        final int m = text1.length();
    final int n = text2.length();
    // dp[i][j] := the length of LCS(text1[0..i), text2[0..j))
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i < m; ++i)
      for (int j = 0; j < n; ++j)
        dp[i + 1][j + 1] = text1.charAt(i) == text2.charAt(j)
                               ? 1 + dp[i][j]
                               : Math.max(dp[i][j + 1], dp[i + 1][j]);

    return dp[m][n];
    }
}
