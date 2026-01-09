class Solution {
    class NodeInfo {
        TreeNode node;
        int depth;
        
        NodeInfo(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    
    private NodeInfo dfs(TreeNode node) {
        if (node == null) {
            return new NodeInfo(null, 0);
        }
        
        NodeInfo left = dfs(node.left);
        NodeInfo right = dfs(node.right);
        
        if (left.depth == right.depth) {
            return new NodeInfo(node, left.depth + 1);
        } else if (left.depth > right.depth) {
            return new NodeInfo(left.node, left.depth + 1);
        } else {
            return new NodeInfo(right.node, right.depth + 1);
        }
    }
}