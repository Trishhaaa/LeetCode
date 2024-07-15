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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap= new HashMap <>();
        Set<Integer> childSet=new HashSet <>();

        for(int[] des: descriptions){
            int parentVal=des[0];
            int childVal=des[1];
            boolean isLeft= des[2]==1;

            //Create parentNode
            nodeMap.putIfAbsent(parentVal, new TreeNode(parentVal));
            //Create child node
            nodeMap.putIfAbsent(childVal, new TreeNode(childVal));

            TreeNode parent=nodeMap.get(parentVal);
            TreeNode child=nodeMap.get(childVal);

            if(isLeft){
                parent.left=child;
            }
            else{
                parent.right=child;
            }
            childSet.add(childVal);
        }

        //rootNode is the node not present in the childSet
        TreeNode root= null;
        for(int val:nodeMap.keySet()){
            if(!childSet.contains(val)){
                root=nodeMap.get(val);
                break;
            }
        }
        return root;
    }
}