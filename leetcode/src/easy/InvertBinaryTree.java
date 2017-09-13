package easy;
import models.TreeNode;

/**
 * Revisited on 9/5/2017, classic interview question, no need more words
 * 
 * https://leetcode.com/problems/invert-binary-tree/
 * @author silent
 *
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
