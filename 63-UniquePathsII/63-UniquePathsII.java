// Last updated: 19/07/2026, 20:07:22
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
12    public ListNode deleteDuplicates(ListNode head) {
13        // Sentinel node to simplify edge cases where the head changes
14        ListNode sentinel = new ListNode(0, head);
15        ListNode prev = sentinel;
16        
17        while (head != null) {
18            // If it's a start of a duplicate sublist
19            if (head.next != null && head.val == head.next.val) {
20                // Move until the end of the duplicate sublist
21                while (head.next != null && head.val == head.next.val) {
22                    head = head.next;
23                }
24                // Skip all duplicates and connect prev to the next distinct node
25                prev.next = head.next;
26            } else {
27                // No duplicate detected, safely move the prev pointer
28                prev = prev.next;
29            }
30            // Move forward in the list
31            head = head.next;
32        }
33        
34        return sentinel.next;
35    }
36}