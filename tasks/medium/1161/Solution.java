import java.util.HashMap;

//10ms
public class Solution {
    private HashMap<Integer,Integer> state = new HashMap<>(); 

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        Solution solve = new Solution();
        System.out.println(solve.maxLevelSum(root));
    }

    private void traverseTree(TreeNode root,int level){
        if (root==null){

            return ;
        }
        
        traverseTree(root.left, level+1);
        if (state.containsKey(level)){
            state.put(level, state.get(level)+root.val);
        }
        else{
            state.put(level, root.val);
        }
        traverseTree(root.right,level-1);

    }
    
    public int maxLevelSum(TreeNode root) {
        state.clear();
        traverseTree(root, 1);
        int maxLevel = 1, maxSum = state.get(1);
        for (int level : state.keySet()){
            int sum = state.get(level);
            if (sum > maxSum){
                maxSum = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}