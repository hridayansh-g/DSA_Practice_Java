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
import java.util.ArrayList;
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null || head.next.next== null){
            return new int[]{-1,-1};
        }
        ListNode slow= head;
        ListNode fast= head.next;
        int nodeNumber=1;

        ArrayList<Integer> a= new ArrayList<>();

        while(fast != null && fast.next!= null){
            nodeNumber++;
            if(fast.val > slow.val && fast.val > fast.next.val){
                // local maxima
                a.add(nodeNumber);

            }
            if(fast.val < slow.val && fast.val < fast.next.val){
                // loacal minima
                a.add(nodeNumber);

            }
            slow= slow.next;
            fast= fast.next;
           
        }

        if(a.size()<2){
             return new int[]{-1,-1};
        }

        int maxDiff=  a.get(a.size()-1) - a.get(0);
        int minDiff= Integer.MAX_VALUE;
        for(int i=0; i< a.size()-1; i++){
            minDiff= Math.min(minDiff, (a.get(i+1) - a.get(i)));
        }
        return new int[]{minDiff, maxDiff};

    }
}