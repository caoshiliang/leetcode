package easy;

import models.TreeNode;

/**
 * Revisit on 9/11/2017
 * 
 * The key point is to set down the recursive format first
 * 
 * 
 * https://leetcode.com/problems/symmetric-tree/
 * @author silent
 * Key Points:
 *     1. Use recursive, confirm the format first.
 *     2. Only if left node value is equal with right node value and left.left & right.right is symmetric
 *     and left.right & right.left is symmetric, return true; otherwise return false
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }
}
