// Last updated: 19/07/2026, 20:04:59
1class Solution {
2    public boolean searchMatrix(int[][] matrix, int target) {
3        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
4            return false;
5        }
6        
7        int m = matrix.length;
8        int n = matrix[0].length;
9        
10        int low = 0;
11        int high = (m * n) - 1;
12        
13        while (low <= high) {
14            int mid = low + (high - low) / 2;
15            
16            // Map 1D index back to 2D coordinates
17            int row = mid / n;
18            int col = mid % n;
19            
20            int midValue = matrix[row][col];
21            
22            if (midValue == target) {
23                return true;
24            } else if (midValue < target) {
25                low = mid + 1; // Search the right half
26            } else {
27                high = mid - 1; // Search the left half
28            }
29        }
30        
31        return false;
32    }
33}