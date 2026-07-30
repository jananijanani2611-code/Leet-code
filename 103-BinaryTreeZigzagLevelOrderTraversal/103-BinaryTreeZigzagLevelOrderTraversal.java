// Last updated: 30/07/2026, 08:54:25
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
20    private int postorderIndex;
21    private Map<Integer, Integer> inorderIndexMap;
22
23    public TreeNode buildTree(int[] inorder, int[] postorder) {
24
25        postorderIndex = postorder.length - 1;
26        inorderIndexMap = new HashMap<>();
27
28  
29        for (int i = 0; i < inorder.length; i++) {
30            inorderIndexMap.put(inorder[i], i);
31        }
32
33        return arrayToTree(postorder, 0, inorder.length - 1);
34    }
35
36    private TreeNode arrayToTree(int[] postorder, int left, int right) {
37
38        if (left > right) {
39            return null;
40        }
41
42        int rootVal = postorder[postorderIndex--];
43        TreeNode root = new TreeNode(rootVal);
44
45        int rootInorderIndex = inorderIndexMap.get(rootVal);
46
47        root.right = arrayToTree(postorder, rootInorderIndex + 1, right);
48        root.left = arrayToTree(postorder, left, rootInorderIndex - 1);
49
50        return root;
51    }
52}