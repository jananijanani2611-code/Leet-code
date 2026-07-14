// Last updated: 14/07/2026, 15:59:39
1class Solution {
2    public int[][] generateMatrix(int n) {
3        int[][] matrix = new int[n][n];
4        
5        int top = 0;
6        int bottom = n - 1;
7        int left = 0;
8        int right = n - 1;
9        
10        int num = 1;
11        int maxNum = n * n;
12        
13        while (num <= maxNum) {
14            // 1. Traverse from left to right along the top row
15            for (int j = left; j <= right; j++) {
16                matrix[top][j] = num++;
17            }
18            top++;
19            
20            // 2. Traverse from top to bottom along the right column
21            for (int i = top; i <= bottom; i++) {
22                matrix[i][right] = num++;
23            }
24            right--;
25            
26            // 3. Traverse from right to left along the bottom row
27            for (int j = right; j >= left; j--) {
28                matrix[bottom][j] = num++;
29            }
30            bottom--;
31            
32            // 4. Traverse from bottom to top along the left column
33            for (int i = bottom; i >= top; i--) {
34                matrix[i][left] = num++;
35            }
36            left++;
37        }
38        
39        return matrix;
40    }
41}