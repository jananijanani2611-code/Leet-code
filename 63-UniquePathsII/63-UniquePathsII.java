// Last updated: 19/07/2026, 20:09:09
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<Integer> grayCode(int n) {
6        List<Integer> result = new ArrayList<>();
7        // Total number of elements in an n-bit sequence is 2^n
8        int numElements = 1 << n; 
9        
10        for (int i = 0; i < numElements; i++) {
11            // Binary to Gray code formula: i ^ (i >> 1)
12            result.add(i ^ (i >> 1));
13        }
14        
15        return result;
16    }
17}