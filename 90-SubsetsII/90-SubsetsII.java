// Last updated: 23/07/2026, 22:43:01
1class Solution {
2    private TreeNode first = null;
3    private TreeNode second = null;
4    private TreeNode prev = null;
5
6    public void recoverTree(TreeNode root) {
7        inorder(root);
8
9       
10        if (first != null && second != null) {
11            int temp = first.val;
12            first.val = second.val;
13            second.val = temp;
14        }
15    }
16
17    private void inorder(TreeNode root) {
18        if (root == null) return;
19
20        inorder(root.left);
21
22       
23        if (prev != null && root.val < prev.val) {
24            if (first == null) {
25                first = prev; 
26            }
27            second = root;    
28        }
29        prev = root;
30
31        inorder(root.right);
32    }
33}