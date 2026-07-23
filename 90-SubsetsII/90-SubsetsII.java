// Last updated: 23/07/2026, 21:46:26
1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<List<Integer>> subsetsWithDup(int[] nums) {
7        List<List<Integer>> result = new ArrayList<>();
8        
9        Arrays.sort(nums);
10        
11        backtrack(0, nums, new ArrayList<>(), result);
12        return result;
13    }
14
15    private void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
16        result.add(new ArrayList<>(current));
17
18        for (int i = start; i < nums.length; i++) {
19            
20            if (i > start && nums[i] == nums[i - 1]) {
21                continue;
22            }
23
24            current.add(nums[i]);
25            
26            backtrack(i + 1, nums, current, result);
27            
28            current.remove(current.size() - 1);
29        }
30    }
31}