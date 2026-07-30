// Last updated: 30/07/2026, 08:55:47
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16import java.util.*;
17
18class Solution {
19    public List<List<Integer>> levelOrderBottom(TreeNode root) {
20        List<List<Integer>> result = new ArrayList<>();
21        if (root == null) {
22            return result;
23        }
24
25        Queue<TreeNode> queue = new LinkedList<>();
26        queue.add(root);
27
28        while (!queue.isEmpty()) {
29            int levelSize = queue.size();
30            List<Integer> currentLevel = new ArrayList<>();
31
32            for (int i = 0; i < levelSize; i++) {
33                TreeNode node = queue.poll();
34                currentLevel.add(node.val);
35
36                if (node.left != null) queue.add(node.left);
37                if (node.right != null) queue.add(node.right);
38            }
39
40            result.add(0, currentLevel);
41        }
42
43        return result;
44    }
45}