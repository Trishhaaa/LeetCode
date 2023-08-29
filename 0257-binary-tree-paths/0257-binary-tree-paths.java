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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths= new ArrayList<>();
        if(root!=null){
            constructPaths(root,"",paths);
        }
        return paths;
    }

    private void constructPaths(TreeNode node, String path, List<String> paths){
        if(node.left==null && node.right==null){
            paths.add(path+node.val);
            return;
        }
        if(node.left!=null){
            constructPaths(node.left, path+node.val+"->",paths);
        }
        if(node.right!=null){
            constructPaths(node.right,path+node.val+"->",paths);
        }
    }
}