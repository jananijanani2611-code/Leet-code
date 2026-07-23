// Last updated: 23/07/2026, 22:39:42
1class Solution {
2    public int numTrees(int n) {
3      
4        int[] dp = new int[n + 1];
5        
6        // Base cases
7        dp[0] = 1; // Empty tree is 1 tree structure
8        dp[1] = 1; 
9        for (int nodes = 2; nodes <= n; nodes++) {
10            for (int root = 1; root <= nodes; root++) {
11                int leftNodes = root - 1;
12                int rightNodes = nodes - root;
13             
14                dp[nodes] += dp[leftNodes] * dp[rightNodes];
15            }
16        }
17        
18        return dp[n];
19    }
20}