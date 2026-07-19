// Last updated: 19/07/2026, 20:04:13
1class Solution {
2    public void setZeroes(int[][] matrix) {
3        int m = matrix.length;
4        int n = matrix[0].length;
5        
6        boolean firstRowZero = false;
7        boolean firstColZero = false;
8        
9        // Step 1: Check if the first row has any zeros
10        for (int j = 0; j < n; j++) {
11            if (matrix[0][j] == 0) {
12                firstRowZero = true;
13                break;
14            }
15        }
16        
17        // Step 1: Check if the first column has any zeros
18        for (int i = 0; i < m; i++) {
19            if (matrix[i][0] == 0) {
20                firstColZero = true;
21                break;
22            }
23        }
24        
25        // Step 2: Use first row and column as markers
26        for (int i = 1; i < m; i++) {
27            for (int j = 1; j < n; j++) {
28                if (matrix[i][j] == 0) {
29                    matrix[i][0] = 0;
30                    matrix[0][j] = 0;
31                }
32            }
33        }
34        
35        // Step 3: Zero out cells based on tokens in first row/column
36        for (int i = 1; i < m; i++) {
37            for (int j = 1; j < n; j++) {
38                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
39                    matrix[i][j] = 0;
40                }
41            }
42        }
43        
44        // Step 4: Zero out the first row if needed
45        if (firstRowZero) {
46            for (int j = 0; j < n; j++) {
47                matrix[0][j] = 0;
48            }
49        }
50        
51        // Step 4: Zero out the first column if needed
52        if (firstColZero) {
53            for (int i = 0; i < m; i++) {
54                matrix[i][0] = 0;
55            }
56        }
57    }
58}