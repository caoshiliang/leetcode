package easy;

import models.TreeNode;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * @author caos1
 *
 */
public class MinimumDepsOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null || root.right == null) {
            TreeNode next = root.left == null ? root.right : root.left;
            return minDepth(next) + 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left < right ? left + 1 : right + 1;
    }
}
