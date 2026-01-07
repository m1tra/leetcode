import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//6ms ВЫВОД: никогда не использовать HashMap в задачи на бинарное дерево(решение с хэшмапом 32 мс)
public class Solution {
    long maxProduct = 0;
    long totalSum = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        Solution solve = new Solution();
        System.out.println(solve.maxProduct(root));
    }

    private long calculateSubtreeSum(TreeNode node) {
        if (node == null) return 0;
        long leftSum = calculateSubtreeSum(node.left);
        long rightSum = calculateSubtreeSum(node.right);
        long currentSum = node.val + leftSum + rightSum;
        maxProduct = Math.max(maxProduct, currentSum * (totalSum - currentSum));
        return currentSum;
    }

    public int maxProduct(TreeNode root) {
        totalSum = getSum(root);
        calculateSubtreeSum(root);
        return (int)(maxProduct % 1_000_000_007);
    }

    private long getSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getSum(node.left) + getSum(node.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}