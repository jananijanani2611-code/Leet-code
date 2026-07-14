// Last updated: 14/07/2026, 15:58:19
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<Integer> spiralOrder(int[][] matrix) {
6        List<Integer> result = new ArrayList<>();
7        if (matrix == null || matrix.length == 0) {
8            return result;
9        }
10        
11        int top = 0;
12        int bottom = matrix.length - 1;
13        int left = 0;
14        int right = matrix[0].length - 1;
15        
16        while (top <= bottom && left <= right) {
17            // 1. Traverse from left to right along the top row
18            for (int j = left; j <= right; j++) {
19                result.add(matrix[top][j]);
20            }
21            top++;
22            
23            // 2. Traverse from top to bottom along the right column
24            for (int i = top; i <= bottom; i++) {
25                result.add(matrix[i][right]);
26            }
27            right--;
28            
29            // 3. Traverse from right to left along the bottom row (if applicable)
30            if (top <= bottom) {
31                for (int j = right; j >= left; j--) {
32                    result.add(matrix[bottom][j]);
33                }
34                bottom--;
35            }
36            
37            // 4. Traverse from bottom to top along the left column (if applicable)
38            if (left <= right) {
39                for (int i = bottom; i >= top; i--) {
40                    result.add(matrix[i][left]);
41                }
42                left++;
43            }
44        }
45        
46        return result;
47    }
48}