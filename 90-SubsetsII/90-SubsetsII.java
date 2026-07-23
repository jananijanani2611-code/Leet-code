// Last updated: 23/07/2026, 21:50:05
1class Solution {
2    public int numDecodings(String s) {
3        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
4            return 0; 
5        }
6
7        int n = s.length();
8        int[] dp = new int[n + 1];
9
10        dp[0] = 1; // Empty string has 1 valid decoding way
11        dp[1] = 1; // Single valid non-zero character has 1 way
12
13        for (int i = 2; i <= n; i++) {
14            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
15            if (oneDigit >= 1 && oneDigit <= 9) {
16                dp[i] += dp[i - 1];
17            }
18
19            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
20            if (twoDigits >= 10 && twoDigits <= 26) {
21                dp[i] += dp[i - 2];
22            }
23        }
24
25        return dp[n];
26    }
27}