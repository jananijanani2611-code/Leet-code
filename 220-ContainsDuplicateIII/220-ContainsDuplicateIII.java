// Last updated: 19/07/2026, 20:16:27
1import java.util.*;
2
3class Solution {
4    public List<String> removeInvalidParentheses(String s) {
5        List<String> result = new ArrayList<>();
6        if (s == null) {
7            return result;
8        }
9        
10        Queue<String> queue = new LinkedList<>();
11        Set<String> visited = new HashSet<>();
12        
13        queue.offer(s);
14        visited.add(s);
15        
16        boolean found = false;
17        
18        while (!queue.isEmpty()) {
19            int size = queue.size();
20            
21            // Process all states at the current "removal depth" level
22            for (int i = 0; i < size; i++) {
23                String curr = queue.poll();
24                
25                if (isValid(curr)) {
26                    result.add(curr);
27                    found = true;
28                }
29                
30                // If a valid string is found at this level, stop generating deeper states
31                if (found) {
32                    continue;
33                }
34                
35                // Generate next states by removing one parenthesis at a time
36                for (int j = 0; j < curr.length(); j++) {
37                    char c = curr.charAt(j);
38                    if (c != '(' && c != ')') {
39                        continue; // Skip alphabetical characters
40                    }
41                    
42                    // Create a candidate string by skipping the character at index j
43                    String nextState = curr.substring(0, j) + curr.substring(j + 1);
44                    if (!visited.contains(nextState)) {
45                        visited.add(nextState);
46                        queue.offer(nextState);
47                    }
48                }
49            }
50            
51            // Break early once the shortest valid paths are exhausted
52            if (found) {
53                break;
54            }
55        }
56        
57        return result;
58    }
59    
60    // Helper function to check if a string contains balanced parentheses
61    private boolean isValid(String str) {
62        int count = 0;
63        for (int i = 0; i < str.length(); i++) {
64            char c = str.charAt(i);
65            if (c == '(') {
66                count++;
67            } else if (c == ')') {
68                count--;
69                if (count < 0) {
70                    return false; // More closing than opening parentheses
71                }
72            }
73        }
74        return count == 0;
75    }
76}