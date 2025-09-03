/**
 * Definition for singly-linked list.
 * public class ListNode {
 *      int val;
 *      ListNode next;
 *      ListNode() {}
 *      ListNode(int val) { this.val = val; }
 *      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummyHead= new ListNode(0, head);
        ListNode temp = dummyHead;
        int prefixSum=0;
        HashMap<Integer, ListNode> h= new HashMap<>();

        while(temp != null){
            prefixSum += temp.val;
            h.put(prefixSum, temp);
            temp= temp.next;
        }

        prefixSum=0;
        temp= dummyHead;
        while(temp != null){
            prefixSum += temp.val;
            temp.next= h.get(prefixSum).next;
            temp= temp.next;
        }
        return dummyHead.next;
    }
}