// Last updated: 19/07/2026, 20:13:13
1class Solution {
2    public int countDigitOne(int n) {
3        if (n <= 0) {
4            return 0;
5        }
6        
7        int count = 0;
8        
9    
10        for (long i = 1; i <= n; i *= 10) {
11            long divider = i * 10;
12            
13            // Number of full groups + remainder contribution
14            count += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0L), i);
15        }
16        
17        return count;
18    }
19}