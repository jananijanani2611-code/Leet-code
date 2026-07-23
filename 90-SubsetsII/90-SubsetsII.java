// Last updated: 23/07/2026, 22:38:50
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<TreeNode> generateTrees(int n) {
6        if (n == 0) return new ArrayList<>();
7        return buildTrees(1, n);
8    }
9
10    private List<TreeNode> buildTrees(int start, int end) {
11        List<TreeNode> allTrees = new ArrayList<>();
12        
13 
14        if (start > end) {
15            allTrees.add(null);
16            return allTrees;
17        }
18
19     
20        for (int i = start; i <= end; i++) {
21            // All possible left subtrees for root 'i'
22            List<TreeNode> leftTrees = buildTrees(start, i - 1);
23            
24            // All possible right subtrees for root 'i'
25            List<TreeNode> rightTrees = buildTrees(i + 1, end);
26
27            // Combine each left and right subtree with root 'i'
28            for (TreeNode left : leftTrees) {
29                for (TreeNode right : rightTrees) {
30                    TreeNode root = new TreeNode(i);
31                    root.left = left;
32                    root.right = right;
33                    allTrees.add(root);
34                }
35            }
36        }
37
38        return allTrees;
39    }
40}