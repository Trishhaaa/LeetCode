/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int length=0;
        length=lengthOfCycle(head);
        if(length==0){
            return null;
        }
        ListNode first=head;
        ListNode second=head;
        
        //move the second pointer length of the cycle times 
        while(length>0){
            second=second.next;
            length--;
        }
        
        //move the first and second pointer one by one
        while(first!=second){
            first=first.next;
            second=second.next;
        }
        return first;
    }

    public int lengthOfCycle(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                //calculate the length;
                int len=0;
                do{
                    len++;
                    slow=slow.next;
                }while(slow!=fast);
                return len;
            }
        }
        return 0;

    }
}