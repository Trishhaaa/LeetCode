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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1=reverseList(l1);
        ListNode list2=reverseList(l2);

        int sum=0;
        int carry=0;
        ListNode ans= new ListNode();

        while(list1!=null || list2!=null){
            if(list1!=null){
                sum+=list1.val;
                list1=list1.next;
            }
            if(list2!=null){
                sum+=list2.val;
                list2=list2.next;
            }

            ans.val=sum%10;
            carry=sum/10;
            ListNode head= new ListNode(carry);
            head.next=ans;
            ans=head;
            sum=carry;
        }

        return carry==0?ans.next:ans;
    }

    private ListNode reverseList(ListNode head){
        ListNode prev=null;
        ListNode temp;

        while(head!=null){
            temp=head.next;
            head.next=prev;
            prev=head;
            head=temp;
        }
        return prev;
    }
}