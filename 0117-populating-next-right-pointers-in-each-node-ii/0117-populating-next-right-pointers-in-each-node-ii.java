/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }

        Queue<Node> queue= new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size= queue.size();
            List<Node> levelNodes= new ArrayList<>();
            for(int i=0;i<size;i++){
                Node curr=queue.poll();
                levelNodes.add(curr);
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }

            for(int i=0;i<levelNodes.size()-1;i++){
                Node node= levelNodes.get(i);
                node.next=levelNodes.get(i+1);
            }
        }
        return root;
            
        
    }
}