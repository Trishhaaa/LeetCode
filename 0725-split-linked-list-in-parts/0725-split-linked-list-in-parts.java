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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result= new ListNode[k];
        int n=0;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            n++;
        }

        int partSize=n/k;
        int extra=n%k;

        curr=head;

        for(int i=0;i<k && curr!=null;i++){
            result[i]=curr;
            int currPartSize=partSize+(i<extra?1:0);

            for(int j=0;j<currPartSize-1;j++){
                curr=curr.next;
            }

            ListNode node= curr.next;
            curr.next=null;
            curr=node;
        }

        return result;
        
    }
}