// Last updated: 23/07/2026, 22:32:15
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
12    public ListNode reverseBetween(ListNode head, int left, int right) {
13        if (head == null || left == right) {
14            return head;
15        }
16
17     
18        ListNode dummy = new ListNode(0);
19        dummy.next = head;
20
21        ListNode prev = dummy;
22        for (int i = 0; i < left - 1; i++) {
23            prev = prev.next;
24        }
25
26        ListNode curr = prev.next;
27
28        for (int i = 0; i < right - left; i++) {
29            ListNode temp = curr.next;
30            curr.next = temp.next;
31            temp.next = prev.next;
32            prev.next = temp;
33        }
34
35        return dummy.next;
36    }
37}