// Last updated: 19/07/2026, 19:51:35
1import java.util.Deque;
2import java.util.ArrayDeque;
3
4class Solution {
5    public String simplifyPath(String path) {
6        Deque<String> stack = new ArrayDeque<>();
7        // Split the path by one or more slashes
8        String[] tokens = path.split("/");
9        
10        for (String token : tokens) {
11            if (token.equals("..")) {
12                if (!stack.isEmpty()) {
13                    stack.pollLast(); // Move up to the parent directory
14                }
15            } else if (!token.equals(".") && !token.isEmpty()) {
16                stack.offerLast(token); // Push valid directory name
17            }
18        }
19        
20        // Reconstruct the canonical path
21        StringBuilder result = new StringBuilder();
22        for (String dir : stack) {
23            result.append("/").append(dir);
24        }
25        
26        // If the stack was empty, return the root directory "/"
27        return result.length() == 0 ? "/" : result.toString();
28    }
29}