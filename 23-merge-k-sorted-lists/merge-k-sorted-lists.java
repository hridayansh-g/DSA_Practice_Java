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
import java.util.*;
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq =
            new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for (ListNode node : lists) if (node != null) pq.offer(node);

        ListNode dummy = new ListNode(0), tail = dummy;

        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            tail.next = min;
            tail = min;
            if (min.next != null) pq.offer(min.next);
        }
        // safety: ensure list ends
        tail.next = null;
        return dummy.next;

        // approach 1
       /* if (lists == null || lists.length == 0) return null;

        ArrayList<Integer> vals = new ArrayList<>();
        for (ListNode head : lists) {
            while (head != null) {
                vals.add(head.val);
                head = head.next;
            }
        }
        if (vals.isEmpty()) return null;

        Collections.sort(vals);

        ListNode dummy = new ListNode(0), tail = dummy;
        for (int v : vals) {
            tail.next = new ListNode(v);
            tail = tail.next;
        }
        return dummy.next;
        */
    }
}