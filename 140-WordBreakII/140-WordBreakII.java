// Last updated: 16/07/2026, 09:02:32
1import java.util.*;
2
3class Solution {
4    // Standard Trie Node class
5    class TrieNode {
6        TrieNode[] children = new TrieNode[26];
7        String word = null; // Stores the complete word at the leaf node
8    }
9
10    public List<String> findWords(char[][] board, String[] words) {
11        List<String> result = new ArrayList<>();
12        TrieNode root = buildTrie(words);
13
14        int m = board.length;
15        int n = board[0].length;
16
17        // Traverse every cell in the matrix as a starting point
18        for (int i = 0; i < m; i++) {
19            for (int j = 0; j < n; j++) {
20                dfs(board, i, j, root, result);
21            }
22        }
23
24        return result;
25    }
26
27    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
28        char ch = board[r][c];
29        
30        // Base case: if cell is already visited ('#') or no prefix matches in Trie
31        if (ch == '#' || node.children[ch - 'a'] == null) {
32            return;
33        }
34
35        node = node.children[ch - 'a'];
36        
37        // If a word is found, add it to the result and clear it to prevent duplicates
38        if (node.word != null) {
39            result.add(node.word);
40            node.word = null; 
41        }
42
43        // Mark the current cell as visited
44        board[r][c] = '#';
45
46        // Explore all 4 neighbors (Up, Down, Left, Right)
47        if (r > 0) dfs(board, r - 1, c, node, result);
48        if (r < board.length - 1) dfs(board, r + 1, c, node, result);
49        if (c > 0) dfs(board, r, c - 1, node, result);
50        if (c < board[0].length - 1) dfs(board, r, c + 1, node, result);
51
52        board[r][c] = ch;
53    }
54
55    private TrieNode buildTrie(String[] words) {
56        TrieNode root = new TrieNode();
57        for (String w : words) {
58            TrieNode node = root;
59            for (char c : w.toCharArray()) {
60                int idx = c - 'a';
61                if (node.children[idx] == null) {
62                    node.children[idx] = new TrieNode();
63                }
64                node = node.children[idx];
65            }
66            node.word = w; 
67        }
68        return root;
69    }
70}