// Last updated: 14/07/2026, 15:59:08
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public int[][] insert(int[][] intervals, int[] newInterval) {
6        List<int[]> result = new ArrayList<>();
7        int i = 0;
8        int n = intervals.length;
9        
10        // 1. Add all intervals that come before the new interval
11        while (i < n && intervals[i][1] < newInterval[0]) {
12            result.add(intervals[i]);
13            i++;
14        }
15        
16        // 2. Merge all overlapping intervals with the new interval
17        while (i < n && intervals[i][0] <= newInterval[1]) {
18            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
19            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
20            i++;
21        }
22        // Add the merged interval
23        result.add(newInterval);
24        
25        // 3. Add all remaining intervals
26        while (i < n) {
27            result.add(intervals[i]);
28            i++;
29        }
30        
31        // Convert the List to a 2D array
32        return result.toArray(new int[result.size()][]);
33    }
34}