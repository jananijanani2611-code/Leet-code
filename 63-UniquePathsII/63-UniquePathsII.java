// Last updated: 19/07/2026, 20:06:06
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<List<Integer>> subsets(int[] nums) {
6        List<List<Integer>> result = new ArrayList<>();
7        backtrack(0, nums, new ArrayList<>(), result);
8        return result;
9    }
10
11    private void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> result) {
12        // Every state of path is a valid subset, add it to the result
13        result.add(new ArrayList<>(path));
14
15        for (int i = start; i < nums.length; i++) {
16            // Include the current element
17            path.add(nums[i]);
18
19            // Move to the next element to build upon the current subset
20            backtrack(i + 1, nums, path, result);
21
22            // Backtrack: exclude the current element before the next iteration
23            path.remove(path.size() - 1);
24        }
25    }
26}