// Last updated: 19/07/2026, 19:50:24
1class Solution {
2    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
3        int m = obstacleGrid.length;
4        int n = obstacleGrid[0].length;
5
6        // If the starting cell has an obstacle, no paths are possible
7        if (obstacleGrid[0][0] == 1) {
8            return 0;
9        }
10
11        // Base case: 1 way to be at the starting point
12        obstacleGrid[0][0] = 1;
13
14        // Fill the first column
15        for (int i = 1; i < m; i++) {
16            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
17        }
18
19        // Fill the first row
20        for (int j = 1; j < n; j++) {
21            obstacleGrid[0][j] = (obstacleGrid[0][j] == 0 && obstacleGrid[0][j - 1] == 1) ? 1 : 0;
22        }
23
24        // Fill the rest of the grid
25        for (int i = 1; i < m; i++) {
26            for (int j = 1; j < n; j++) {
27                if (obstacleGrid[i][j] == 1) {
28                    obstacleGrid[i][j] = 0; // Obstacle blocks paths
29                } else {
30                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
31                }
32            }
33        }
34
35        return obstacleGrid[m - 1][n - 1];
36    }
37}