// Last updated: 30/07/2026, 08:53:30
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
16import java.util.HashMap;
17import java.util.Map;
18
19class Solution {
20    private int preorderIndex;
21    private Map<Integer, Integer> inorderIndexMap;
22
23    public TreeNode buildTree(int[] preorder, int[] inorder) {
24        preorderIndex = 0;
25        inorderIndexMap = new HashMap<>();
26
27        // Store value -> index mappings for O(1) lookup in inorder array
28        for (int i = 0; i < inorder.length; i++) {
29            inorderIndexMap.put(inorder[i], i);
30        }
31
32        return arrayToTree(preorder, 0, inorder.length - 1);
33    }
34
35    private TreeNode arrayToTree(int[] preorder, int left, int right) {
36    
37        if (left > right) {
38            return null;
39        }
40
41        int rootVal = preorder[preorderIndex++];
42        TreeNode root = new TreeNode(rootVal);
43
44    
45        int rootInorderIndex = inorderIndexMap.get(rootVal);
46
47        root.left = arrayToTree(preorder, left, rootInorderIndex - 1);
48        root.right = arrayToTree(preorder, rootInorderIndex + 1, right);
49
50        return root;
51    }
52}