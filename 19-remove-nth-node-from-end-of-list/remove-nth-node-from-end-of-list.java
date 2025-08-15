/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
         int len = 0;
        for (ListNode p = head; p != null; p = p.next) len++;

        int idx = len - n;          
        if (idx == 0) return head.next; 

        ListNode p = head;
        for (int i = 1; i < idx; i++) p = p.next; 
        p.next = p.next.next;
        return head;
    }
}