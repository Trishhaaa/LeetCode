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
            return null;
        }
        Node curr=head;
        //1. Create a new node for every node and insert it next to the original node
        while(curr!=null){
            Node newNode= new Node(curr.val);
            newNode.next=curr.next;
            curr.next=newNode;
            curr=newNode.next;
        }

        //2. Update the random pointers of the new nodes
        curr=head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }

        //3. Separate the new list from the original list
        Node newHead=head.next;
        curr=head;
        Node newCurr=newHead;
        while(curr!=null){
            curr.next=newCurr.next;
            if(newCurr.next!=null){
                newCurr.next=curr.next.next;
            }
            newCurr=newCurr.next;
            curr=curr.next;
        }
        return newHead;
    }
}