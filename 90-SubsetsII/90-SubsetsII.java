// Last updated: 23/07/2026, 22:37:37
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<String> restoreIpAddresses(String s) {
6        List<String> result = new ArrayList<>();
7        // An IP address must have between 4 and 12 characters
8        if (s == null || s.length() < 4 || s.length() > 12) {
9            return result;
10        }
11        backtrack(s, 0, new ArrayList<>(), result);
12        return result;
13    }
14
15    private void backtrack(String s, int startIndex, List<String> current, List<String> result) {
16        // Base case: 4 valid segments found
17        if (current.size() == 4) {
18            if (startIndex == s.length()) {
19                result.add(String.join(".", current));
20            }
21            return;
22        }
23
24        // Try placing a segment of length 1, 2, or 3
25        for (int len = 1; len <= 3; len++) {
26            if (startIndex + len > s.length()) {
27                break;
28            }
29
30            String segment = s.substring(startIndex, startIndex + len);
31
32            // Validation rules:
33            // 1. Segment cannot have leading zeros (e.g. "01" is invalid, "0" is valid)
34            // 2. Value must be <= 255
35            if ((segment.startsWith("0") && segment.length() > 1) || Integer.parseInt(segment) > 255) {
36                continue;
37            }
38
39            current.add(segment);
40            backtrack(s, startIndex + len, current, result);
41            current.remove(current.size() - 1); // backtrack
42        }
43    }
44}