// Last updated: 14/07/2026, 16:18:01
1class Solution {
2    public int candy(int[] ratings) {
3        int n = ratings.length;
4        if (n <= 1) {
5            return n;
6        }
7        
8        int[] candies = new int[n];
9        
10        // Step 1: Every child gets at least 1 candy
11        for (int i = 0; i < n; i++) {
12            candies[i] = 1;
13        }
14        
15        // Step 2: Left-to-Right pass
16        for (int i = 1; i < n; i++) {
17            if (ratings[i] > ratings[i - 1]) {
18                candies[i] = candies[i - 1] + 1;
19            }
20        }
21        
22        // Step 3: Right-to-Left pass and count the total sum
23        int totalCandies = candies[n - 1];
24        for (int i = n - 2; i >= 0; i--) {
25            if (ratings[i] > ratings[i + 1]) {
26                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
27            }
28            totalCandies += candies[i];
29        }
30        
31        return totalCandies;
32    }
33}