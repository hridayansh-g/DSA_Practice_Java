/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;
public class Solution {
    public boolean hasCycle(ListNode head) {
         if (head == null || head.next == null) return false;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true; 
        }
        return false;

        // approach 1
      /*  HashSet<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (seen.contains(head)) return true;
            seen.add(head);
            head = head.next;
        }
        return false;
        */
    }
}