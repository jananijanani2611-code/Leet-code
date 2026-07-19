// Last updated: 19/07/2026, 20:33:05
1import java.util.*;
2
3class SummaryRanges {
4    private TreeMap<Integer, int[]> treeMap;
5
6    public SummaryRanges() {
7        treeMap = new TreeMap<>();
8    }
9    
10    public void addNum(int value) {
11        if (treeMap.containsKey(value)) return;
12        
13        Integer l = treeMap.lowerKey(value);
14        Integer h = treeMap.higherKey(value);
15        
16        // Case 1: value is already covered by the lower interval
17        if (l != null && treeMap.get(l)[1] >= value) {
18            return;
19        }
20        
21        boolean mergeWithLeft = (l != null && treeMap.get(l)[1] + 1 == value);
22        boolean mergeWithRight = (h != null && h == value + 1);
23        
24        if (mergeWithLeft && mergeWithRight) {
25            // Case 2: value bridges both lower and higher intervals
26            treeMap.get(l)[1] = treeMap.get(h)[1];
27            treeMap.remove(h);
28        } else if (mergeWithLeft) {
29            // Case 3: value extends the lower interval to the right
30            treeMap.get(l)[1] = value;
31        } else if (mergeWithRight) {
32            // Case 4: value extends the higher interval to the left
33            int[] rightInterval = treeMap.remove(h);
34            treeMap.put(value, new int[]{value, rightInterval[1]});
35        } else {
36            // Case 5: value creates a standalone single-element interval
37            treeMap.put(value, new int[]{value, value});
38        }
39    }
40    
41    public int[][] getIntervals() {
42        int[][] result = new int[treeMap.size()][2];
43        int i = 0;
44        for (int[] interval : treeMap.values()) {
45            result[i++] = interval;
46        }
47        return result;
48    }
49}