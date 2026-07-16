// Last updated: 16/07/2026, 08:59:31
1import java.util.*;
2
3class Solution {
4    
5    private Map<Integer, List<String>> memo;
6    private Set<String> wordSet;
7
8    public List<String> wordBreak(String s, List<String> wordDict) {
9        this.memo = new HashMap<>();
10        this.wordSet = new HashSet<>(wordDict); // O(1) lookups
11        return backtrack(s, 0);
12    }
13
14    private List<String> backtrack(String s, int start) {
15        
16        if (memo.containsKey(start)) {
17            return memo.get(start);
18        }
19
20        List<String> results = new ArrayList<>();
21        if (start == s.length()) {
22            results.add("");
23            return results;
24        }
25
26        for (int end = start + 1; end <= s.length(); end++) {
27            String prefix = s.substring(start, end);
28            
29          
30            if (wordSet.contains(prefix)) {
31                List<String> subSentences = backtrack(s, end);
32                
33                for (String sub : subSentences) {
34                    if (sub.isEmpty()) {
35                        results.add(prefix); 
36                    } else {
37                        results.add(prefix + " " + sub);
38                    }
39                }
40            }
41        }
42        memo.put(start, results);
43        return results;
44    }
45}