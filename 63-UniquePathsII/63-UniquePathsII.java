// Last updated: 19/07/2026, 20:06:49
1class Solution {
2    public int removeDuplicates(int[] nums) {
3        // If the array has 2 or fewer elements, it already satisfies the condition
4        if (nums.length <= 2) {
5            return nums.length;
6        }
7        
8        // Pointer to place the next valid element
9        int k = 2;
10        
11        // Iterate through the array starting from the 3rd element
12        for (int i = 2; i < nums.length; i++) {
13            // Check if the current element is different from the element placed 2 positions back
14            if (nums[i] != nums[k - 2]) {
15                nums[k] = nums[i];
16                k++;
17            }
18        }
19        
20        return k;
21    }
22}