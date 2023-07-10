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
    public boolean isPalindrome(ListNode head) {
        ListNode mid= middle(head);
        ListNode headSecond=reverse(mid);
        ListNode rereverse=headSecond;

        while(head!=null && headSecond!=null){
            if(head.val!=headSecond.val){
                break;
            }
            head=head.next;
            headSecond=headSecond.next;
        }
        reverse(rereverse);
        if(head==null||headSecond==null){
            return true;
        }
        return false;
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
            return null;
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