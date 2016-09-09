package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import models.TreeNode;
/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * @author silent
 * Key Points:
 *    1. Use queue to traverse in level order;
 *    2. Use count to keep aware of start and end of every level
 *    3. Use LinkedList and insert into every level's elements' list at 0
 *    because it's a bottom up level traverse
 */
public class BinaryTreeLevelTraverse {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        // NOTE: It's required to use bottom up level traverse
        // So we need to add bottom level's elements in front position
        // which means insert, to use linked list is of more effience
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int count = 1;
        while (!q.isEmpty()) {
            int nextCount = 0;
            List<Integer> vals = new ArrayList<Integer>();
            while (count > 0) {
                TreeNode current = q.remove();
                if (current.left != null) {
                    q.add(current.left);
                    nextCount ++;
                }
                if (current.right != null) {
                    q.add(current.right);
                    nextCount ++;
                }
                vals.add(current.val);
                count --;
            }
            result.add(0, vals);
            count = nextCount;
        }
        return result;
    }
}
