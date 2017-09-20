/**
 * Created on Sep 19, 2017 7:01:19 PM
 */
package easy;

import models.TreeNode;

/**
 * @author caos1
 *
 */
public class TrimBinarySearchTree {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null || root.val > R || root.val < L) {
            return null;
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
