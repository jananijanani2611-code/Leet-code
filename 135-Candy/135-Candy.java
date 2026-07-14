// Last updated: 14/07/2026, 16:20:19
1import java.util.HashMap;
2import java.util.Map;
3
4class Solution {
5    public int maxPoints(int[][] points) {
6        int n = points.length;
7        if (n <= 2) {
8            return n;
9        }
10        
11        int maxPoints = 0;
12        
13        // Iterate through each point as the "anchor"
14        for (int i = 0; i < n; i++) {
15            Map<String, Integer> slopeMap = new HashMap<>();
16            int localMax = 0;
17            
18            for (int j = i + 1; j < n; j++) {
19                int dx = points[j][0] - points[i][0];
20                int dy = points[j][1] - points[i][1];
21                
22                // Reduce the fraction using Greatest Common Divisor (GCD)
23                int gcd = gcd(dx, dy);
24                dx /= gcd;
25                dy /= gcd;
26                
27                // Ensure unique representation for negative directions
28                // E.g., (-1)/2 and 1/(-2) should be mapped to the same string
29                if (dx < 0) {
30                    dx = -dx;
31                    dy = -dy;
32                } else if (dx == 0) {
33                    // Vertical line representation
34                    dy = 1;
35                }
36                
37                String slope = dy + "/" + dx;
38                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
39                localMax = Math.max(localMax, slopeMap.get(slope));
40            }
41            
42            // Add 1 to include the anchor point itself
43            maxPoints = Math.max(maxPoints, localMax + 1);
44        }
45        
46        return maxPoints;
47    }
48    
49    // Helper method to calculate the Greatest Common Divisor
50    private int gcd(int a, int b) {
51        if (b == 0) {
52            return a;
53        }
54        return gcd(b, a % b);
55    }
56}