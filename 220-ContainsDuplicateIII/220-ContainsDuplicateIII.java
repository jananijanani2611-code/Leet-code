// Last updated: 19/07/2026, 20:14:38
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<String> addOperators(String num, int target) {
6        List<String> result = new ArrayList<>();
7        if (num == null || num.length() == 0) {
8            return result;
9        }
10        // Using StringBuilder to optimize string concatenations during backtracking
11        backtrack(num, target, 0, 0, 0, new StringBuilder(), result);
12        return result;
13    }
14
15    private void backtrack(String num, int target, int index, long currentTotal, long prevApplied, StringBuilder path, List<String> result) {
16        // Base case: if we have processed all characters
17        if (index == num.length()) {
18            if (currentTotal == target) {
19                result.add(path.toString());
20            }
21            return;
22        }
23
24        int len = path.length();
25
26        for (int i = index; i < num.length(); i++) {
27            // Rule 1: Prevent numbers with leading zeros (e.g., "05")
28            if (i > index && num.charAt(index) == '0') {
29                break;
30            }
31
32            long currentVal = Long.parseLong(num.substring(index, i + 1));
33
34            // If it is the first number in the expression, it has no preceding operator
35            if (index == 0) {
36                path.append(currentVal);
37                backtrack(num, target, i + 1, currentVal, currentVal, path, result);
38                path.setLength(len); // Backtrack
39            } else {
40                // Scenario 1: Add '+' operator
41                path.append("+").append(currentVal);
42                backtrack(num, target, i + 1, currentTotal + currentVal, currentVal, path, result);
43                path.setLength(len); // Backtrack
44
45                // Scenario 2: Add '-' operator
46                path.append("-").append(currentVal);
47                backtrack(num, target, i + 1, currentTotal - currentVal, -currentVal, path, result);
48                path.setLength(len); // Backtrack
49
50                // Scenario 3: Add '*' operator (Precedence Handling)
51                path.append("*").append(currentVal);
52                backtrack(num, target, i + 1, (currentTotal - prevApplied) + (prevApplied * currentVal), prevApplied * currentVal, path, result);
53                path.setLength(len); // Backtrack
54            }
55        }
56    }
57}