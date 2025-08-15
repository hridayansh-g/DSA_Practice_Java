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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer> vals = new ArrayList<>();
        for (ListNode p = list1; p != null; p = p.next) vals.add(p.val);
        for (ListNode q = list2; q != null; q = q.next) vals.add(q.val);
        if (vals.isEmpty()) return null;

        Collections.sort(vals);

        ListNode dummy = new ListNode(0), tail = dummy;
        for (int v : vals) {
            tail.next = new ListNode(v);
            tail = tail.next;
        }
        return dummy.next;
    }
}