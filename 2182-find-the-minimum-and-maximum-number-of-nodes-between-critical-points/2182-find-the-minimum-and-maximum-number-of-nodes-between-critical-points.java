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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[] {-1, -1};
        }
        int firstCrit=-1;
        int lastCrit=-1;
        int minDist=Integer.MAX_VALUE;
        int maxDist=-1;

        int index=1;

        ListNode prev=head;
        ListNode curr=head.next;
        ListNode next=head.next.next;

        while(next!=null){
            if((curr.val>prev.val && curr.val>next.val) || curr.val<next.val && curr.val<prev.val){
                if(firstCrit==-1){
                    firstCrit=index;
                }
                else{
                    minDist=Math.min(minDist, index-lastCrit);
                }
                maxDist=index-firstCrit;
                lastCrit=index;
            }
            prev=curr;
            curr=next;
            next=next.next;
            index++;
        }
        if(firstCrit==lastCrit){
            return new int[] {-1,-1};
        }
        return new int[] {minDist, maxDist};
    }
}