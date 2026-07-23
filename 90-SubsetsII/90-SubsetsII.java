// Last updated: 23/07/2026, 22:41:55
1class Solution {
2    public boolean isInterleave(String s1, String s2, String s3) {
3        int m = s1.length();
4        int n = s2.length();
5
6        // Length check: s3 must be equal to s1 + s2 length
7        if (m + n != s3.length()) {
8            return false;
9        }
10
11        boolean[][] dp = new boolean[m + 1][n + 1];
12        dp[0][0] = true;
13
14        // Initialize first column (using only s1)
15        for (int i = 1; i <= m; i++) {
16            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
17        }
18
19        // Initialize first row (using only s2)
20        for (int j = 1; j <= n; j++) {
21            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
22        }
23
24        // Fill the DP table
25        for (int i = 1; i <= m; i++) {
26            for (int j = 1; j <= n; j++) {
27                char currentS3 = s3.charAt(i + j - 1);
28                
29                boolean fromS1 = dp[i - 1][j] && s1.charAt(i - 1) == currentS3;
30                boolean fromS2 = dp[i][j - 1] && s2.charAt(j - 1) == currentS3;
31
32                dp[i][j] = fromS1 || fromS2;
33            }
34        }
35
36        return dp[m][n];
37    }
38}