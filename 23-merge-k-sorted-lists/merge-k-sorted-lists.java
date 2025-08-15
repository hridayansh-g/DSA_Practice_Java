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
        int n = lists.length;
        int step = 1;
        while (step < n) {
            for (int i = 0; i + step < n; i += step << 1) {
                lists[i] = mergeTwo(lists[i], lists[i + step]);
            }
            step <<= 1;
        }
        return lists[0];
    }

    // In-place merge of two sorted lists
    private ListNode mergeTwo(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;

        ListNode head, tail;
        if (a.val <= b.val) { head = tail = a; a = a.next; }
        else               { head = tail = b; b = b.next; }

        while (a != null && b != null) {
            if (a.val <= b.val) { tail.next = a; a = a.next; }
            else                { tail.next = b; b = b.next; }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
        return head;
    }

    /*
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
       if (lists == null || lists.length == 0) return null;

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
        
    } */
    
}