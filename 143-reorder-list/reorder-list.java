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

        ArrayList<ListNode> a = new ArrayList<>();
        for (ListNode p = head; p != null; p = p.next) a.add(p);

        int i = 0, j = a.size() - 1;
        while (i < j) {
            a.get(i).next = a.get(j); i++;
            if (i == j) break;
            a.get(j).next = a.get(i); j--;
        }
        a.get(i).next = null; 
    }
}