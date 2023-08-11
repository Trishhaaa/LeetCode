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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode n=new ListNode(0);
        n.next=head;
        ListNode node= n;

        while(node.next!=null && node.next.next!=null){
            if(node.next.val==node.next.next.val){
                int dup=node.next.val;
                while(node.next!=null && node.next.val==dup){
                    node.next=node.next.next;
                }
            }
            else{
                node=node.next;
            }
        }
        return n.next;
    }
}