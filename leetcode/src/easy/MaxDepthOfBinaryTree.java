package easy;
import models.TreeNode;

/**
 * Revisit on 9/5/2017
 * 
 * When writing recursive solutions, important point is to set the outlet condition in the beginning
 * Recursive solution without this outlet condition is wrong and cause stack overflow
 * 
 * 
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
}
