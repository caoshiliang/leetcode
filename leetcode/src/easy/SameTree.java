package easy;

import models.TreeNode;

/**
 * Visited on 9/11/2017
 * 
 * https://leetcode.com/problems/same-tree/
 * @author silent
 *
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
