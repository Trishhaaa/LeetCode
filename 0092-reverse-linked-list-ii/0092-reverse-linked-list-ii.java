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
    public ListNode reverseBetween(ListNode head, int l, int r) {
        if(l==r){
            return head;
        }
        ListNode prev=null;
        ListNode present=head;
        for(int i=0;i<l-1 && present!=null;i++){
            prev=present;
            present=present.next;
        }
        ListNode last=prev;
        ListNode newEnd=present;
        ListNode next=present.next;
        for(int i=0;i<r-l+1&& present!=null;i++){
            present.next=prev;
            prev=present;
            present=next;
            if(next!=null){
                next=next.next;
            }
        }
        if(last!=null){
            last.next=prev;
        }
        else{
            head=prev;
        }
        newEnd.next=present;
        return head;
    }
}