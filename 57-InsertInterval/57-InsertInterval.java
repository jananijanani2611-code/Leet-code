// Last updated: 14/07/2026, 16:02:30
1class Solution {
2    public int uniquePaths(int m, int n) {
3        // Optimize space: use a 1D array of size n
4        int[] dp = new int[n];
5        
6        // Base case: There is exactly 1 way to reach any cell in the first row
7        for (int j = 0; j < n; j++) {
8            dp[j] = 1;
9        }
10        
11        // Build the DP table row by row
12        for (int i = 1; i < m; i++) {
13            for (int j = 1; j < n; j++) {
14                // dp[j] (new) = dp[j] (from above row) + dp[j-1] (from left neighbor)
15                dp[j] += dp[j - 1];
16            }
17        }
18        
19        return dp[n - 1];
20    }
21}