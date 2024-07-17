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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest= new ArrayList<>();
        Set<Integer> toDel= new HashSet<>();

        for(int val: to_delete){
            toDel.add(val);
        }
        if(!toDel.contains(root.val)){
            forest.add(root);
        }
        dfs(root, toDel, forest);
        return forest;
    }

    private TreeNode dfs(TreeNode node, Set<Integer> toDel, List<TreeNode> forest ){
        if(node==null){
            return null;
        }

        node.left=dfs(node.left, toDel, forest);
        node.right=dfs(node.right, toDel, forest);

        if(toDel.contains(node.val)){
            if(node.left!=null){
                forest.add(node.left);
            }
            if(node.right!=null){
                forest.add(node.right);
            }
            return null;
        }
        return node;
    }
}