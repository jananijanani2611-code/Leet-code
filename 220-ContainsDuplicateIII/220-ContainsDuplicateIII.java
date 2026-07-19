// Last updated: 19/07/2026, 20:35:56
1import java.util.Arrays;
2
3class Solution {
4    public int maxEnvelopes(int[][] envelopes) {
5        if (envelopes == null || envelopes.length == 0) return 0;
6        
7        // Sort width ascending, and height descending if widths are equal
8        Arrays.sort(envelopes, (a, b) -> {
9            if (a[0] == b[0]) {
10                return b[1] - a[1];
11            } else {
12                return a[0] - b[0];
13            }
14        });
15        
16        // Find the Longest Increasing Subsequence (LIS) on heights
17        int[] dp = new int[envelopes.length];
18        int len = 0;
19        
20        for (int[] envelope : envelopes) {
21            int height = envelope[1];
22            int idx = Arrays.binarySearch(dp, 0, len, height);
23            
24            // If the element is not found, binarySearch returns -(insertion point) - 1
25            if (idx < 0) {
26                idx = -(idx + 1);
27            }
28            
29            dp[idx] = height;
30            if (idx == len) {
31                len++;
32            }
33        }
34        
35        return len;
36    }
37}