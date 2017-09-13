package easy;

import models.TreeNode;
/**
 * Revisit on 9/9/2017, add a new solution
 * 
 * 
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


    /**
     * A new solution of same design, but more simple
     * @param root
     * @param sum
     * @return
     */
    public boolean another(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return recursive(root, sum, 0);
    }
    
    public boolean recursive(TreeNode root, int sum, int acc) {
        if (root.left == null && root.right == null) {
            return acc + root.val == sum;
        }
        return (root.left != null && recursive(root.left, sum, acc + root.val))
                || (root.right != null && recursive(root.right, sum, acc + root.val));
    }
}
