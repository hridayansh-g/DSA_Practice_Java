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
    public void reorderList(ListNode head) {
         if (head == null || head.next == null) return;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; fast = fast.next.next;
        }

        ListNode prev = null, cur = slow.next;
        slow.next = null; // split
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }

        ListNode p1 = head, p2 = prev;
        while (p2 != null) {
            ListNode t1 = p1.next, t2 = p2.next;
            p1.next = p2;
            p2.next = t1;
            p1 = t1;
            p2 = t2;
        }

        // approach
        /* if (head == null || head.next == null) return;

        ArrayList<ListNode> a = new ArrayList<>();
        for (ListNode p = head; p != null; p = p.next) a.add(p);

        int i = 0, j = a.size() - 1;
        while (i < j) {
            a.get(i).next = a.get(j); i++;
            if (i == j) break;
            a.get(j).next = a.get(i); j--;
        }
        a.get(i).next = null; 
        */
    }
}