// Last updated: 19/07/2026, 20:14:01
1class Solution {
2    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
3    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
4    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
5
6    public String numberToWords(int num) {
7        if (num == 0) {
8            return "Zero";
9        }
10
11        String words = "";
12        int i = 0;
13
14        // Process the number in groups of 3 digits (thousands)
15        while (num > 0) {
16            if (num % 1000 != 0) {
17                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
18            }
19            num /= 1000;
20            i++;
21        }
22
23        return words.trim();
24    }
25
26    // Helper function to process numbers less than 1000
27    private String helper(int num) {
28        if (num == 0) {
29            return "";
30        } else if (num < 20) {
31            return LESS_THAN_20[num] + " ";
32        } else if (num < 100) {
33            return TENS[num / 10] + " " + helper(num % 10);
34        } else {
35            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
36        }
37    }
38}