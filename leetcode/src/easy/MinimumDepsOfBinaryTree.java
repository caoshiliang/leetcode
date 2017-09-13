package easy;

import models.TreeNode;

/**
 * Revisit on 9/5/2017
 * 
 * Removed useless condition
 * 
 * NOTE:there's a little optimization:
 * 
 * When there's only one child for a node, we can avoid computing the depth of the non-null child
 * Because we're expecting to get the minimal path, which comes from the null child definitely.
 * 
 * 
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * @author caos1
 *
 */
public class MinimumDepsOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
//        if (root.left == null && root.right == null) {
//            return 1;
//        }
        if (root.left == null || root.right == null) {
            TreeNode next = root.left == null ? root.right : root.left;
            return minDepth(next) + 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left < right ? left + 1 : right + 1;
    }
}
