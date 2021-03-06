package easy;

import models.TreeNode;

/**
 * Revisit on 9/5/2017
 * 
 * BST's important feature:
 *  smaller values on left, and bigger values on right
 *  so if a node whose value is smaller than one and bigger than the other,
 *  that's the common ancestor of these two nodes.
 * 
 * 
 * 
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 
 * @author silent
 * Key points:
 *     1. LCA node could be a node whose value is between these 2 ones or one of these 2.
 *     2. Time complexity is O(logN) since won't search more times than the depth of tree
 */
public class lowestCommonAncestor {

    public TreeNode getLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        // won't run here
        return null;
    }
}
