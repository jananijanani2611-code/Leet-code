// Last updated: 16/07/2026, 09:01:28
1import java.util.Arrays;
2
3class Solution {
4    public int maxProfit(int k, int[] prices) {
5        int n = prices.length;
6        if (n <= 1 || k == 0) {
7            return 0;
8        }
9        if (k >= n / 2) {
10            int maxProfit = 0;
11            for (int i = 1; i < n; i++) {
12                if (prices[i] > prices[i - 1]) {
13                    maxProfit += prices[i] - prices[i - 1];
14                }
15            }
16            return maxProfit;
17        }
18
19     
20        int[] buy = new int[k + 1];
21        int[] sell = new int[k + 1];
22
23     
24        Arrays.fill(buy, Integer.MIN_VALUE);
25
26        for (int price : prices) {
27            for (int i = 1; i <= k; i++) {
28               
29                buy[i] = Math.max(buy[i], sell[i - 1] - price);
30              
31                sell[i] = Math.max(sell[i], buy[i] + price);
32            }
33        }
34
35        return sell[k];
36    }
37}