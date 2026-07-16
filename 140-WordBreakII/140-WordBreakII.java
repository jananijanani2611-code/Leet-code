// Last updated: 16/07/2026, 09:03:13
1class Solution {
2    public String shortestPalindrome(String s) {
3        if (s == null || s.length() <= 1) {
4            return s;
5        }
6
7        // Reverse the original string
8        String reversed = new StringBuilder(s).reverse().toString();
9        
10        // Combine s and reversed with a separator
11        String temp = s + "#" + reversed;
12        
13        // Compute the KMP LPS array for the combined string
14        int[] lps = computeLPS(temp);
15        
16        // The length of the longest palindromic prefix
17        int longestPalindromicPrefixLength = lps[temp.length() - 1];
18        
19        // The remaining part of the reversed string needs to be added to the front
20        String suffixToAdd = reversed.substring(0, s.length() - longestPalindromicPrefixLength);
21        
22        return suffixToAdd + s;
23    }
24
25    private int[] computeLPS(String str) {
26        int n = str.length();
27        int[] lps = new int[n];
28        int len = 0; // Length of the previous longest prefix suffix
29        int i = 1;
30
31        while (i < n) {
32            if (str.charAt(i) == str.charAt(len)) {
33                len++;
34                lps[i] = len;
35                i++;
36            } else {
37                if (len != 0) {
38                    len = lps[len - 1]; // Fallback to the previous match
39                } else {
40                    lps[i] = 0;
41                    i++;
42                }
43            }
44        }
45        return lps;
46    }
47}