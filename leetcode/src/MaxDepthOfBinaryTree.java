import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * @author silent
 *
 */
public class MaxDepthOfBinaryTree {

    /*
     * recursive method
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
