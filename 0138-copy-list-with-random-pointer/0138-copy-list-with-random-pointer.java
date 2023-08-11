/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        Node curr= head;
        while(curr!=null){
            Node newNode= new Node(curr.val);
            newNode.next=curr.next;
            curr.next=newNode;
            curr=newNode.next;
        }

        curr= head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }

        Node newHead= head.next;
        Node copiedCurr=newHead;
        curr=head;
        while(curr!=null){
            curr.next=curr.next.next;
            if(copiedCurr.next!=null){
                copiedCurr.next=copiedCurr.next.next;
            }

            copiedCurr=copiedCurr.next;
            curr=curr.next;
        }

        return newHead;
    }
}