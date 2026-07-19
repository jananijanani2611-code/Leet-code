// Last updated: 19/07/2026, 20:18:00
1class Solution {
2    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
3        int m = nums1.length;
4        int n = nums2.length;
5        int[] maxResult = new int[k];
6        
7        // Determine the valid range of elements to take from nums1
8        int start = Math.max(0, k - n);
9        int end = Math.min(k, m);
10        
11        for (int i = start; i <= end; i++) {
12            // Step 1: Max subsequence of size i from nums1 and size k-i from nums2
13            int[] sub1 = maxSubarray(nums1, i);
14            int[] sub2 = maxSubarray(nums2, k - i);
15            
16            // Step 2: Merge the two subsequences greedily
17            int[] merged = merge(sub1, sub2, k);
18            
19            // Step 3: Keep track of the globally maximum combined number
20            if (isGreater(merged, 0, maxResult, 0)) {
21                maxResult = merged;
22            }
23        }
24        
25        return maxResult;
26    }
27    
28    // Helper to find the maximum subsequence of a specific length using a Monotonic Stack strategy
29    private int[] maxSubarray(int[] nums, int length) {
30        int[] result = new int[length];
31        int top = 0; // stack pointer
32        int dropElements = nums.length - length;
33        
34        for (int i = 0; i < nums.length; i++) {
35            while (top > 0 && result[top - 1] < nums[i] && dropElements > 0) {
36                top--;
37                dropElements--;
38            }
39            if (top < length) {
40                result[top++] = nums[i];
41            } else {
42                dropElements--;
43            }
44        }
45        return result;
46    }
47    
48    // Helper to merge two arrays greedily by looking ahead on duplicates
49    private int[] merge(int[] sub1, int[] sub2, int k) {
50        int[] merged = new int[k];
51        int p1 = 0, p2 = 0;
52        
53        for (int i = 0; i < k; i++) {
54            if (isGreater(sub1, p1, sub2, p2)) {
55                merged[i] = sub1[p1++];
56            } else {
57                merged[i] = sub2[p2++];
58            }
59        }
60        return merged;
61    }
62    
63    // Lexicographical look-ahead comparison function
64    private boolean isGreater(int[] sub1, int p1, int[] sub2, int p2) {
65        while (p1 < sub1.length && p2 < sub2.length) {
66            if (sub1[p1] > sub2[p2]) return true;
67            if (sub1[p1] < sub2[p2]) return false;
68            p1++;
69            p2++;
70        }
71        return p1 < sub1.length; // If one runs out, pick the one with remaining elements
72    }
73}