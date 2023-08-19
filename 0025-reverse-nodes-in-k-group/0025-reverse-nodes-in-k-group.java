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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr=head;
        int count=0;
        while(count<k && curr!=null){
            curr=curr.next;
            count++;
        }

        if(count==k){
            ListNode prev=reverseKGroup(curr,k);
            while(count>0){
                ListNode next=head.next;
                head.next=prev;
                prev=head;
                head=next;
                count--;
            }
            return prev;
        }

        return head;
    }
}