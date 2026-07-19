// Last updated: 19/07/2026, 20:10:58
1class Solution {
2    public int calculateMinimumHP(int[][] dungeon) {
3        int m = dungeon.length;
4        int n = dungeon[0].length;
5        
6        // dp array to store minimum health needed for the current row's columns
7        int[] dp = new int[n];
8        
9        // Base case: Minimum health needed *after* rescuing the princess is 1
10        dp[n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
11        
12        // Fill the last row (can only move right)
13        for (int j = n - 2; j >= 0; j--) {
14            dp[j] = Math.max(1, dp[j + 1] - dungeon[m - 1][j]);
15        }
16        
17        // Fill the rest of the grid from bottom to top
18        for (int i = m - 2; i >= 0; i--) {
19            // Last column of the current row (can only move down)
20            dp[n - 1] = Math.max(1, dp[n - 1] - dungeon[i][n - 1]);
21            
22            // Fill the rest of the columns in the current row
23            for (int j = n - 2; j >= 0; j--) {
24                int minHealthOnExit = Math.min(dp[j], dp[j + 1]); // min of down and right
25                dp[j] = Math.max(1, minHealthOnExit - dungeon[i][j]);
26            }
27        }
28        
29        return dp[0];
30    }
31}