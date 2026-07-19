// Last updated: 19/07/2026, 20:11:47
1import java.util.HashMap;
2import java.util.Map;
3
4class Solution {
5    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
6        if (nums == null || nums.length < 2 || indexDiff <= 0 || valueDiff < 0) {
7            return false;
8        }
9
10        // Map to store the bucket ID and the actual number currently in it
11        Map<Long, Long> buckets = new HashMap<>();
12        long width = (long) valueDiff + 1; // Size of each bucket
13
14        for (int i = 0; i < nums.length; i++) {
15            long mappedVal = (long) nums[i];
16            long bucketId = getBucketId(mappedVal, width);
17
18            // Condition 1: Current bucket already has a number
19            if (buckets.containsKey(bucketId)) {
20                return true;
21            }
22            
23            // Condition 2: Check the adjacent left bucket
24            if (buckets.containsKey(bucketId - 1) && Math.abs(mappedVal - buckets.get(bucketId - 1)) <= valueDiff) {
25                return true;
26            }
27            
28            // Condition 3: Check the adjacent right bucket
29            if (buckets.containsKey(bucketId + 1) && Math.abs(mappedVal - buckets.get(bucketId + 1)) <= valueDiff) {
30                return true;
31            }
32
33            // Add the current number to its bucket
34            buckets.put(bucketId, mappedVal);
35
36            // Maintain the sliding window size of indexDiff
37            if (i >= indexDiff) {
38                long oldBucketId = getBucketId((long) nums[i - indexDiff], width);
39                buckets.remove(oldBucketId);
40            }
41        }
42
43        return false;
44    }
45
46    // Helper to calculate bucket ID supporting negative numbers
47    private long getBucketId(long val, long width) {
48        if (val >= 0) {
49            return val / width;
50        } else {
51            return (val + 1) / width - 1;
52        }
53    }
54}