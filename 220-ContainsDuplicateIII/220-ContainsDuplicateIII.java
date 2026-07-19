// Last updated: 19/07/2026, 20:23:36
1class Solution {
2    public int minPatches(int[] nums, int n) {
3        long miss = 1; // The smallest number we cannot currently form
4        int patches = 0; // Number of patches applied
5        int i = 0; // Pointer for the nums array
6
7        while (miss <= n) {
8            if (i < nums.length && nums[i] <= miss) {
9                // If the current element can help extend the range, use it
10                miss += nums[i];
11                i++;
12            } else {
13                // Otherwise, greedily patch 'miss' into the array
14                miss += miss;
15                patches++;
16            }
17        }
18
19        return patches;
20    }
21}