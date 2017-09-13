package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import models.TreeNode;
/**
 * Revisit on 9/4/2017: because the dequeue operation happens mixed with enqueue opertion of next layer
 * So Must know the count of current layer nodes, which should have been recorded when enqueueing nodes
 * of this layer
 * 
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * @author silent
 * Key Points:
 *    1. Use queue;
 *    2. Track number of next level when putting in;
 *    3. Track number of current level when getting out, and put elements' list into result once
 *    current level is fully removed.
 */
public class BinaryTreeLevelOrderTraverse {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int count = 1;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (!q.isEmpty()) {
            int nextCount = 0;
            List<Integer> current = new ArrayList<>();
            while (count > 0) {
                TreeNode node = q.remove();
                current.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                    nextCount ++;
                }
                if (node.right != null) {
                    q.add(node.right);
                    nextCount ++;
                }
                count --;
            }
            count = nextCount;
            result.add(current);
        }
        return result;
    }
}
