// Last updated: 14/07/2026, 16:20:46
1class Solution {
2    public int findMin(int[] nums) {
3        int low = 0;
4        int high = nums.length - 1;
5        
6        while (low < high) {
7            int mid = low + (high - low) / 2;
8            
9            if (nums[mid] > nums[high]) {
10                // Minimum is in the right unsorted subarray
11                low = mid + 1;
12            } else if (nums[mid] < nums[high]) {
13                // Minimum is at mid or in the left subarray
14                high = mid;
15            } else {
16                // nums[mid] == nums[high]
17                // We cannot be sure which side to discard, so shrink the search space safely
18                high--;
19            }
20        }
21        
22        return nums[low];
23    }
24}