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
    private TreeNode findLCA(TreeNode root, int startValue, int destValue) {
        if (root == null) return null;
        if (root.val == startValue || root.val == destValue) return root;
        
        TreeNode left = findLCA(root.left, startValue, destValue);
        TreeNode right = findLCA(root.right, startValue, destValue);
        
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    // Step 2: Find the path from the given node to a target value
    private boolean findPath(TreeNode root, int value, StringBuilder path) {
        if (root == null) return false;
        if (root.val == value) return true;
        
        if (root.left != null && findPath(root.left, value, path)) {
            path.append('L');
            return true;
        }
        if (root.right != null && findPath(root.right, value, path)) {
            path.append('R');
            return true;
        }
        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);

        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        // Step 3: Find paths from the LCA to start and destination nodes
        findPath(lca, startValue, pathToStart);
        findPath(lca, destValue, pathToDest);

        // Step 4: Reverse the paths since they were constructed from the target node to the LCA
        pathToStart.reverse();
        pathToDest.reverse();

        // Step 5: Create the final path string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pathToStart.length(); i++) {
            result.append('U');
        }
        result.append(pathToDest);

        return result.toString();
    }
}