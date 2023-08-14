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

    private int postIndex; 

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex=postorder.length-1;
        return helper(inorder, postorder,  0, inorder.length-1);
    }

    private TreeNode helper(int[] inorder, int[] postorder,  int inStart, int inEnd){
        if(inStart>inEnd){
            return null;
        }

        int rootVal=postorder[postIndex];
        TreeNode root= new TreeNode(rootVal);
        postIndex--;

        int rootIndex=inStart;
        while(rootIndex<=inEnd && inorder[rootIndex]!=rootVal){
            rootIndex++;
        }

        root.right=helper(inorder, postorder, rootIndex+1, inEnd);
        root.left=helper(inorder, postorder, inStart, rootIndex-1);

        return root;
    }
}