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
        if(head== null || head.next== null || head.next.next == null){
            return new int[]{-1, -1};
        }

        int prev=-1, cur=-1, nex= -1;
        ListNode previous= head;
        ListNode current= head.next;
        int idx = 1;

        int minDiff= Integer.MAX_VALUE;

        while(current != null && current.next != null ){
            idx++;
            if((current.val< previous.val && current.val< current.next.val) || 
                (current.val> previous.val && current.val> current.next.val)){
                    if(prev == -1){
                        prev= idx;
                          cur= idx;
                    }
                    else{
                         minDiff= Math.min(minDiff, idx- cur);
                          cur= idx;
                    }
                    
                    nex= idx;
                }
            current= current.next;
            previous= previous.next;

        }

        if (prev == -1 || prev == nex) return new int[]{-1, -1};
        return new int[]{minDiff, nex-prev};



        /*
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
        */

    }
}