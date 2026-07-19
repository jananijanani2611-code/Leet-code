// Last updated: 19/07/2026, 20:17:16
1class Solution {
2    public int maxCoins(int[] nums) {
3        int n = nums.length;
4        
5        // Pad the original array with 1 at both boundaries
6        int[] vals = new int[n + 2];
7        vals[0] = 1;
8        vals[n + 1] = 1;
9        for (int i = 0; i < n; i++) {
10            vals[i + 1] = nums[i];
11        }
12        
13        // dp[l][r] stores max coins obtained from bursting balloons in open interval (l, r)
14        int[][] dp = new int[n + 2][n + 2];
15        
16        // k represents the distance (length) between left and right boundary
17        for (int k = 2; k <= n + 1; k++) {
18            // left boundary pointer
19            for (int left = 0; left <= n + 2 - k - 1; left++) {
20                int right = left + k;
21                
22                // Try every balloon 'i' inside the open interval (left, right) as the last to burst
23                for (int i = left + 1; i < right; i++) {
24                    int currentCoins = vals[left] * vals[i] * vals[right] // reward for bursting 'i' last
25                                     + dp[left][i]                        // max coins from left subproblem
26                                     + dp[i][right];                       // max coins from right subproblem
27                    
28                    dp[left][right] = Math.max(dp[left][right], currentCoins);
29                }
30            }
31        }
32        
33        return dp[0][n + 1];
34    }
35}