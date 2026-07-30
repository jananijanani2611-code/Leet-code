// Last updated: 30/07/2026, 09:15:49
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11/**
12 * Definition for a binary tree node.
13 * public class TreeNode {
14 *     int val;
15 *     TreeNode left;
16 *     TreeNode right;
17 *     TreeNode() {}
18 *     TreeNode(int val) { this.val = val; }
19 *     TreeNode(int val, TreeNode left, TreeNode right) {
20 *         this.val = val;
21 *         this.left = left;
22 *         this.right = right;
23 *     }
24 * }
25 */
26class Solution {
27    public TreeNode sortedListToBST(ListNode head) {
28        if (head == null) {
29            return null;
30        }
31        if (head.next == null) {
32            return new TreeNode(head.val);
33        }
34
35       
36        ListNode prev = null;
37        ListNode slow = head;
38        ListNode fast = head;
39
40        while (fast != null && fast.next != null) {
41            prev = slow;
42            slow = slow.next;
43            fast = fast.next.next;
44        }
45
46        if (prev != null) {
47            prev.next = null;
48        }
49
50        TreeNode root = new TreeNode(slow.val);
51
52        root.left = sortedListToBST(head);
53        root.right = sortedListToBST(slow.next);
54
55        return root;
56    }
57}