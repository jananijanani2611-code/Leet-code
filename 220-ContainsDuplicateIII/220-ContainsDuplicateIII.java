// Last updated: 19/07/2026, 20:12:34
1import java.util.Stack;
2
3class Solution {
4    public int calculate(String s) {
5        Stack<Integer> stack = new Stack<>();
6        int result = 0;
7        int number = 0;
8        int sign = 1; // 1 means positive, -1 means negative
9
10        for (int i = 0; i < s.length(); i++) {
11            char c = s.charAt(i);
12
13            if (Character.isDigit(c)) {
14                number = 10 * number + (c - '0');
15            } else if (c == '+') {
16                result += sign * number;
17                number = 0;
18                sign = 1;
19            } else if (c == '-') {
20                result += sign * number;
21                number = 0;
22                sign = -1;
23            } else if (c == '(') {
24                // Push the current result and sign onto the stack
25                stack.push(result);
26                stack.push(sign);
27                
28                // Reset the sign and result for the new sub-expression
29                sign = 1;
30                result = 0;
31            } else if (c == ')') {
32                result += sign * number;
33                number = 0;
34                
35                // Multiply by the sign before the parenthesis
36                result *= stack.pop();
37                // Add to the result computed before the parenthesis
38                result += stack.pop();
39            }
40        }
41        
42        // Add the last remaining number if any
43        if (number != 0) {
44            result += sign * number;
45        }
46        
47        return result;
48    }
49}