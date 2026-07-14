// Last updated: 14/07/2026, 16:02:01
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
12    public ListNode rotateRight(ListNode head, int k) {
13        // Base cases: empty list, single node, or no rotation needed
14        if (head == null || head.next == null || k == 0) {
15            return head;
16        }
17        
18        // 1. Calculate the length of the list and find the tail node
19        ListNode tail = head;
20        int length = 1;
21        while (tail.next != null) {
22            tail = tail.next;
23            length++;
24        }
25        
26        // 2. Adjust k to be within the bounds of the list size
27        k = k % length;
28        if (k == 0) {
29            return head; // No rotation needed
30        }
31        
32        // 3. Connect the tail to the head to form a circular loop
33        tail.next = head;
34        
35        // 4. Find the new tail node
36        // The new tail is at index (length - k - 1) from the start
37        int stepsToNewTail = length - k;
38        ListNode newTail = tail; 
39        for (int i = 0; i < stepsToNewTail; i++) {
40            newTail = newTail.next;
41        }
42        
43        // 5. Break the circle and update the head
44        ListNode newHead = newTail.next;
45        newTail.next = null;
46        
47        return newHead;
48    }
49}