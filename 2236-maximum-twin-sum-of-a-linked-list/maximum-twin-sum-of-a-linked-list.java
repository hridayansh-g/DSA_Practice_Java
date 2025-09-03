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
    public int pairSum(ListNode head) {

        // find mid
        ListNode fast= head;
        ListNode slow= head;
        while(fast.next!= null && fast.next.next!= null){
            fast= fast.next.next;
            slow= slow.next;
        }
        
        // reverse after mid
        ListNode prev= null;
        ListNode cur= slow.next;
        while(cur != null){
            ListNode nex= cur.next;
            cur.next= prev;
            prev= cur;
            cur= nex;
        }
        slow.next= null;
        // prev is head of half reversed list

        int sum=0;
        int maxSum=0;;
        ListNode temp= head;

        while(prev!= null && temp != null){
            sum= prev.val + temp.val;
            maxSum= Math.max(sum, maxSum);

            prev= prev.next;
            temp= temp.next;
        }
        return maxSum;

    }
}