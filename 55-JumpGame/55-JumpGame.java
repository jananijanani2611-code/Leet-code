// Last updated: 19/07/2026, 19:49:27
1class Solution {
2    public boolean canJump(int[] nums) {
3        int maxReachable = 0;
4        
5        for (int i = 0; i < nums.length; i++) {
6            // If the current index is unreachable, we cannot proceed
7            if (i > maxReachable) {
8                return false;
9            }
10            
11            // Update the furthest index we can reach
12            maxReachable = Math.max(maxReachable, i + nums[i]);
13            
14            // Optimization: If we can already reach the last index, return true
15            if (maxReachable >= nums.length - 1) {
16                return true;
17            }
18        }
19        
20        return true;
21    }
22}