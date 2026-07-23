// Last updated: 23/07/2026, 22:46:51
1import java.util.ArrayList;
2import java.util.LinkedList;
3import java.util.List;
4import java.util.Queue;
5
6class Solution {
7    public List<List<Integer>> levelOrder(TreeNode root) {
8        List<List<Integer>> result = new ArrayList<>();
9        if (root == null) {
10            return result;
11        }
12
13        Queue<TreeNode> queue = new LinkedList<>();
14        queue.offer(root);
15
16        while (!queue.isEmpty()) {
17            int levelSize = queue.size();
18            List<Integer> currentLevel = new ArrayList<>();
19
20            for (int i = 0; i < levelSize; i++) {
21                TreeNode currentNode = queue.poll();
22                currentLevel.add(currentNode.val);
23
24                if (currentNode.left != null) {
25                    queue.offer(currentNode.left);
26                }
27                if (currentNode.right != null) {
28                    queue.offer(currentNode.right);
29                }
30            }
31
32            result.add(currentLevel);
33        }
34
35        return result;
36    }
37}