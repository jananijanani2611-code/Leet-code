// Last updated: 19/07/2026, 20:03:09
1class Solution {
2    public int minDistance(String word1, String word2) {
3        int m = word1.length();
4        int n = word2.length();
5        
6        // dp array to store distances for the current row
7        int[] dp = new int[n + 1];
8        
9        // Base case: transforming empty word1 to word2[0...j] requires j insertions
10        for (int j = 0; j <= n; j++) {
11            dp[j] = j;
12        }
13        
14        // Fill the DP table row by row
15        for (int i = 1; i <= m; i++) {
16            int pre = dp[0]; // Stores the top-left corner value (dp[i-1][j-1])
17            dp[0] = i;       // Base case: transforming word1[0...i] to empty word2 requires i deletions
18            
19            for (int j = 1; j <= n; j++) {
20                int temp = dp[j]; // Save the current value before it gets overwritten
21                
22                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
23                    dp[j] = pre; // Characters match, carry over the diagonal value
24                } else {
25                    // Min of Replace (pre), Delete (dp[j]), Insert (dp[j-1]) + 1
26                    dp[j] = 1 + Math.min(pre, Math.min(dp[j], dp[j - 1]));
27                }
28                
29                pre = temp; // Update top-left for the next iteration
30            }
31        }
32        
33        return dp[n];
34    }
35}