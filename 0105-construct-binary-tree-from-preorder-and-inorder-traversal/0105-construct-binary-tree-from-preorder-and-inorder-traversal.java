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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length-1,inorder, 0, inorder.length-1);
    }

    private static TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){

        if(preStart>preEnd || inStart>inEnd){
            return null;
        }

        int rootVal=preorder[preStart];
        TreeNode root= new TreeNode(rootVal);
        int inRoot=0;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==rootVal){
                inRoot=i;
                break;
            }
        }

        int leftSubTreeSize=inRoot-inStart;

        root.left=helper(preorder,preStart+1, preStart+leftSubTreeSize, inorder, inStart, inRoot+1);
        root.right= helper(preorder, preStart+leftSubTreeSize+1, preEnd, inorder, inRoot+1, inEnd);

        return root;
    }
}