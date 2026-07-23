// Last updated: 23/07/2026, 21:40:41
1class Solution {
2    public boolean exist(char[][] board, String word) {
3        int m = board.length;
4        int n = board[0].length;
5
6        int[] boardCounts = new int[128];
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                boardCounts[board[i][j]]++;
10            }
11        }
12
13        int[] wordCounts = new int[128];
14        for (char c : word.toCharArray()) {
15            wordCounts[c]++;
16            if (wordCounts[c] > boardCounts[c]) {
17                return false; 
18            }
19        }
20
21        if (boardCounts[word.charAt(word.length() - 1)] < boardCounts[word.charAt(0)]) {
22            word = new StringBuilder(word).reverse().toString();
23        }
24
25        for (int i = 0; i < m; i++) {
26            for (int j = 0; j < n; j++) {
27                if (board[i][j] == word.charAt(0)) {
28                    if (dfs(board, word, i, j, 0)) {
29                        return true;
30                    }
31                }
32            }
33        }
34
35        return false;
36    }
37
38    private boolean dfs(char[][] board, String word, int r, int c, int index) {
39        if (index == word.length()) {
40            return true;
41        }
42
43        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
44            return false;
45        }
46
47        char temp = board[r][c];
48        board[r][c] = '#';
49
50        boolean found = dfs(board, word, r + 1, c, index + 1)
51                     || dfs(board, word, r - 1, c, index + 1)
52                     || dfs(board, word, r, c + 1, index + 1)
53                     || dfs(board, word, r, c - 1, index + 1);
54
55        board[r][c] = temp;
56
57        return found;
58    }
59}