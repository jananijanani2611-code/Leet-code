// Last updated: 30/07/2026, 08:52:28
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
19    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
20        List<List<Integer>> result = new ArrayList<>();
21        if (root == null) {
22            return result;
23        }
24
25        Queue<TreeNode> queue = new LinkedList<>();
26        queue.add(root);
27        boolean leftToRight = true;
28
29        while (!queue.isEmpty()) {
30            int size = queue.size();
31            LinkedList<Integer> currentLevel = new LinkedList<>();
32
33            for (int i = 0; i < size; i++) {
34                TreeNode node = queue.poll();
35
36                if (leftToRight) {
37                    currentLevel.addLast(node.val);
38                } else {
39                    currentLevel.addFirst(node.val);
40                }
41
42                if (node.left != null) queue.add(node.left);
43                if (node.right != null) queue.add(node.right);
44            }
45
46            result.add(currentLevel);
47            leftToRight = !leftToRight; 
48        }
49
50        return result;
51    }
52}