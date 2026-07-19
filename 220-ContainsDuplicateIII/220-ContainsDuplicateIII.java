// Last updated: 19/07/2026, 20:21:52
1class Solution {
2    public int countRangeSum(int[] nums, int lower, int upper) {
3        int n = nums.length;
4        long[] prefixSums = new long[n + 1];
5        
6        // Build the prefix sums array
7        for (int i = 0; i < n; i++) {
8            prefixSums[i + 1] = prefixSums[i] + nums[i];
9        }
10        
11        return mergeSortAndCount(prefixSums, 0, n, lower, upper);
12    }
13    
14    private int mergeSortAndCount(long[] prefix, int start, int end, int lower, int upper) {
15        if (start >= end) {
16            return 0;
17        }
18        
19        int mid = start + (end - start) / 2;
20        // Count valid range sums in the left and right halves independently
21        int count = mergeSortAndCount(prefix, start, mid, lower, upper) +
22                    mergeSortAndCount(prefix, mid + 1, end, lower, upper);
23        
24        // Count valid range sums that cross between the left and right halves
25        int low = mid + 1;
26        int high = mid + 1;
27        
28        for (int i = start; i <= mid; i++) {
29            // Find the first index 'low' where prefix[low] - prefix[i] >= lower
30            while (low <= end && prefix[low] - prefix[i] < lower) {
31                low++;
32            }
33            // Find the first index 'high' where prefix[high] - prefix[i] > upper
34            while (high <= end && prefix[high] - prefix[i] <= upper) {
35                high++;
36            }
37            // The number of valid j indices for the current i is (high - low)
38            count += (high - low);
39        }
40        
41        // Standard merge step to keep the prefix array sorted
42        merge(prefix, start, mid, end);
43        
44        return count;
45    }
46    
47    private void merge(long[] prefix, int start, int mid, int end) {
48        long[] temp = new long[end - start + 1];
49        int i = start, j = mid + 1, k = 0;
50        
51        while (i <= mid && j <= end) {
52            if (prefix[i] <= prefix[j]) {
53                temp[k++] = prefix[i++];
54            } else {
55                temp[k++] = prefix[j++];
56            }
57        }
58        
59        while (i <= mid) {
60            temp[k++] = prefix[i++];
61        }
62        while (j <= end) {
63            temp[k++] = prefix[j++];
64        }
65        
66        System.arraycopy(temp, 0, prefix, start, temp.length);
67    }
68}