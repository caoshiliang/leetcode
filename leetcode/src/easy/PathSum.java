package easy;

import models.TreeNode;
/**
 * https://leetcode.com/problems/path-sum/
 * @author silent
 * Key Points:
 *    1. Pay attention to when to return from recursive, not till null
 *    Should till the real leaf node, consider input [[1,2],1]
 *    2. If the node is null, should return false
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                return true;
            } else {
                return false;
            }
        }
        if (root.left == null || root.right == null) {
            TreeNode next = root.left == null ? root.right : root.left;
            return hasPathSum(next, sum - root.val);
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
