// Last updated: 16/07/2026, 09:04:00
1import java.util.*;
2
3class Solution {
4    public List<List<Integer>> getSkyline(int[][] buildings) {
5        List<List<Integer>> result = new ArrayList<>();
6        List<int[]> events = new ArrayList<>();
7        
8        // 1. Convert buildings into start and end events
9        for (int[] b : buildings) {
10            // Use negative height for start event
11            events.add(new int[]{b[0], -b[2]});
12            // Use positive height for end event
13            events.add(new int[]{b[1], b[2]});
14        }
15        
16        // 2. Sort events based on the rules described above
17        Collections.sort(events, (a, b) -> {
18            if (a[0] != b[0]) {
19                return a[0] - b[0];
20            }
21            return a[1] - b[1];
22        });
23        
24        // Max-heap to keep track of the current highest buildings
25        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
26        // Ground level is always an option
27        maxHeap.offer(0);
28        
29        int prevMaxHeight = 0;
30        
31        // 3. Process the events across the sweep line
32        for (int[] event : events) {
33            int x = event[0];
34            int height = event[1];
35            
36            if (height < 0) {
37                // Start of a building, add to active heights
38                maxHeap.offer(-height);
39            } else {
40                // End of a building, remove from active heights
41                maxHeap.remove(height);
42            }
43            
44            // Get the current peak height
45            int currentMaxHeight = maxHeap.peek();
46           
47            if (currentMaxHeight != prevMaxHeight) {
48                result.add(Arrays.asList(x, currentMaxHeight));
49                prevMaxHeight = currentMaxHeight;
50            }
51        }
52        
53        return result;
54    }
55}