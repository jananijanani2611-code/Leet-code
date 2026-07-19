// Last updated: 19/07/2026, 20:08:40
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
11class Solution {
12    public ListNode partition(ListNode head, int x) {
13        // Dummy nodes to anchor the start of both chains
14        ListNode beforeHead = new ListNode(0);
15        ListNode afterHead = new ListNode(0);
16        
17        // Pointers used to build up the two lists
18        ListNode before = beforeHead;
19        ListNode after = afterHead;
20        
21        while (head != null) {
22            if (head.val < x) {
23                before.next = head;
24                before = before.next;
25            } else {
26                after.next = head;
27                after = after.next;
28            }
29            head = head.next;
30        }
31        
32        // Cut off any remaining nodes to prevent cycles
33        after.next = null;
34        
35        // Link the end of the 'before' list to the beginning of the 'after' list
36        before.next = afterHead.next;
37        
38        return beforeHead.next;
39    }
40}