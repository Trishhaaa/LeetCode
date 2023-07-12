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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow=head;
        ListNode fast=head;

        //putting the initial difference between slow and fast equal to n
        for(int i=0;i<n;i++){
            fast=fast.next;
        }

        if(fast==null){
            return head.next;
        }

        //when fast reaches the end, slow reaches the node before the node to be deleted.
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        // now skip the node that has to be deleted
        slow.next=slow.next.next;
        return head;

    }
}