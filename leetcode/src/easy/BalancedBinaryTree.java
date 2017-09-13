package easy;

import models.TreeNode;

/**
 * 
 * Revisited on 9/4/2017
 * https://leetcode.com/problems/balanced-binary-tree/
 * @author silent
 * Key Points:
 *     1. Need to compare left length and right length, judge left tree's balance, right tree's
 *     but calculations have overlap, need to avoid that.
 *     2. Find a viable recursive format, calculate length, and during calculating, mark isBalanced
 *     as false if left and right is not balanced.
 */
public class BalancedBinaryTree {
    private boolean isBalanced = true;
    private int length(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = length(root.left);
        int right = length(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return left > right ? left + 1 : right + 1;
    }
    public boolean isBalanced(TreeNode root) {
        length(root);
        return isBalanced;
        
    }
}
