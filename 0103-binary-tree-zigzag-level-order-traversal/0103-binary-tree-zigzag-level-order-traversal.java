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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        if(root==null){
            return result;
        }   

        Deque<TreeNode> deque= new LinkedList<>();
        boolean leftToRight=true;
        deque.add(root);

        while(!deque.isEmpty()){
            int levelSize=deque.size();
            List<Integer> levelValues= new ArrayList<>();

            for(int i=0;i<levelSize;i++){
                if(leftToRight){
                    TreeNode curr=deque.pollFirst();
                    levelValues.add(curr.val);

                    if(curr.left!=null){
                        deque.offerLast(curr.left);
                    }
                    if(curr.right!=null){
                        deque.offerLast(curr.right);
                    }

                }
                else{
                    TreeNode curr= deque.pollLast();
                    levelValues.add(curr.val);

                    if(curr.right!=null){
                        deque.offerFirst(curr.right);
                    }
                    if(curr.left!=null){
                        deque.offerFirst(curr.left);
                    }
                }
            }
            result.add(levelValues);
            leftToRight=!leftToRight;

        }
        return result;
    }
}