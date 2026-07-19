// Last updated: 19/07/2026, 20:05:34
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<List<Integer>> combine(int n, int k) {
6        List<List<Integer>> result = new ArrayList<>();
7        backtrack(1, n, k, new ArrayList<>(), result);
8        return result;
9    }
10    
11    private void backtrack(int start, int n, int k, List<Integer> path, List<List<Integer>> result) {
12        // Base case: if the combination is done
13        if (path.size() == k) {
14            result.add(new ArrayList<>(path));
15            return;
16        }
17        
18        // Optimize the loop range by pruning branches that won't have enough numbers
19        int remainingNeeded = k - path.size();
20        for (int i = start; i <= n - remainingNeeded + 1; i++) {
21            // Add the current number to the path
22            path.add(i);
23            
24            // Move on to the next number
25            backtrack(i + 1, n, k, path, result);
26            
27            // Backtrack: remove the last number before trying the next option
28            path.remove(path.size() - 1);
29        }
30    }
31}