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
        if(head==null||head.next==null){
            return;
        }

        ListNode mid=middle(head);
        ListNode s=head;
        ListNode e=reverse(mid);
        while(s!=null && e!=null){
            ListNode temp=s.next;
            s.next=e;
            s=temp;
            temp=e.next;
            e.next=s;
            e=temp;
        }

        //setting next of tail to null
        if(s!=null){
            s.next=null;
        }
    }

    static ListNode middle(ListNode head){
        ListNode s=head;
        ListNode f=head;
        while(f!=null&&f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return s;
    }

    static ListNode reverse(ListNode head){
        if(head==null){
            return head;
        }
        ListNode prev=null;
        ListNode present=head;
        ListNode next=present.next;
        while(present!=null){
            present.next=prev;
            prev=present;
            present=next;
            if(next!=null){
                next=next.next;
            }
        }
        return prev;
    }
}