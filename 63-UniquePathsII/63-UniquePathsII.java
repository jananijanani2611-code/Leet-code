// Last updated: 19/07/2026, 19:50:56
1class Solution {
2    public int minPathSum(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        
6        // Fill the first row (can only come from the left)
7        for (int j = 1; j < n; j++) {
8            grid[0][j] += grid[0][j - 1];
9        }
10        
11        // Fill the first column (can only come from above)
12        for (int i = 1; i < m; i++) {
13            grid[i][0] += grid[i - 1][0];
14        }
15        
16        // Fill the rest of the grid
17        for (int i = 1; i < m; i++) {
18            for (int j = 1; j < n; j++) {
19                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
20            }
21        }
22        
23        // The bottom-right cell now contains the minimum path sum
24        return grid[m - 1][n - 1];
25    }
26}