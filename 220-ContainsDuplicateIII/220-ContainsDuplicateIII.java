// Last updated: 19/07/2026, 20:27:26
1class Solution {
2    public boolean isSelfCrossing(int[] distance) {
3        int n = distance.length;
4        if (n <= 3) return false;
5        
6        for (int i = 3; i < n; i++) {
7     
8            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
9                return true;
10            }
11            
12 
13            if (i >= 4 && distance[i - 1] == distance[i - 3] && distance[i] + distance[i - 4] >= distance[i - 2]) {
14                return true;
15            }
16            
17      
18            if (i >= 5 && distance[i - 1] <= distance[i - 3] 
19                       && distance[i - 1] + distance[i - 5] >= distance[i - 3] 
20                       && distance[i - 2] >= distance[i - 4] 
21                       && distance[i] + distance[i - 4] >= distance[i - 2]) {
22                return true;
23            }
24        }
25        
26        return false;
27    }
28}