// Last updated: 19/07/2026, 20:32:05
1import java.util.*;
2
3class Solution {
4    public List<List<Integer>> palindromePairs(String[] words) {
5        List<List<Integer>> pairs = new ArrayList<>();
6        if (words == null || words.length < 2) return pairs;
7        
8        Map<String, Integer> map = new HashMap<>();
9        for (int i = 0; i < words.length; i++) {
10            map.put(words[i], i);
11        }
12        
13        for (int i = 0; i < words.length; i++) {
14            String word = words[i];
15            int len = word.length();
16            
17            for (int j = 0; j <= len; j++) {
18                String left = word.substring(0, j);
19                String right = word.substring(j);
20                
21                // Case 1: left is a palindrome, check if reversed(right) exists
22                if (isPalindrome(left)) {
23                    String revRight = new StringBuilder(right).reverse().toString();
24                    if (map.containsKey(revRight) && map.get(revRight) != i) {
25                        pairs.add(Arrays.asList(map.get(revRight), i));
26                    }
27                }
28                
29                // Case 2: right is a palindrome, check if reversed(left) exists
30                // If right is empty (j == len), it is already fully handled as an empty left in Case 1 
31                // for the other word, so we only run this when j < len.
32                if (j < len && isPalindrome(right)) {
33                    String revLeft = new StringBuilder(left).reverse().toString();
34                    if (map.containsKey(revLeft) && map.get(revLeft) != i) {
35                        pairs.add(Arrays.asList(i, map.get(revLeft)));
36                    }
37                }
38            }
39        }
40        
41        return pairs;
42    }
43    
44    private boolean isPalindrome(String s) {
45        int left = 0, right = s.length() - 1;
46        while (left < right) {
47            if (s.charAt(left++) != s.charAt(right--)) return false;
48        }
49        return true;
50    }
51}