// Last updated: 19/07/2026, 20:22:35
1class Solution {
2    // Direction vectors for moving up, down, left, and right
3    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
4
5    public int longestIncreasingPath(int[][] matrix) {
6        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
7            return 0;
8        }
9
10        int m = matrix.length;
11        int n = matrix[0].length;
12        int[][] memo = new int[m][n];
13        int maxLength = 0;
14
15        // Calculate the longest path starting from each cell
16        for (int i = 0; i < m; i++) {
17            for (int j = 0; j < n; j++) {
18                maxLength = Math.max(maxLength, dfs(matrix, i, j, memo));
19            }
20        }
21
22        return maxLength;
23    }
24
25    private int dfs(int[][] matrix, int row, int col, int[][] memo) {
26        // Return the result immediately if it has already been computed
27        if (memo[row][col] != 0) {
28            return memo[row][col];
29        }
30
31        int max = 1; // Minimum path length starting at any cell is 1
32
33        // Explore all 4 neighboring directions
34        for (int[] dir : DIRECTIONS) {
35            int nextRow = row + dir[0];
36            int nextCol = col + dir[1];
37
38            // Verify boundaries and ensure the next cell value is strictly increasing
39            if (nextRow >= 0 && nextRow < matrix.length && 
40                nextCol >= 0 && nextCol < matrix[0].length && 
41                matrix[nextRow][nextCol] > matrix[row][col]) {
42                
43                int length = 1 + dfs(matrix, nextRow, nextCol, memo);
44                max = Math.max(max, length);
45            }
46        }
47
48        // Cache the result in the memoization grid before returning
49        memo[row][col] = max;
50        return max;
51    }
52}