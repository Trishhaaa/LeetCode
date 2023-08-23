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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private ListNode current;
    public TreeNode sortedListToBST(ListNode head) {
        int length=findLength(head);
        current=head;
        return constructBST(length);
    }

    private int findLength(ListNode head){
        int length=0;
        while(head!=null){
            head=head.next;
            length++;
        }
        return length;
    }

    private TreeNode constructBST(int length){
        if(length<=0){
            return null;
        }

        TreeNode left=constructBST(length/2);
        TreeNode root= new TreeNode(current.val);
        current=current.next;
        TreeNode right= constructBST(length-length/2-1);

        root.left=left;
        root.right=right;

        return root;
    }
}