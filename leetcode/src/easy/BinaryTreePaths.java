package easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import models.TreeNode;
/**
 * Revisit on 9/4/2017, add one more solution, which add paths when going down
 * 
 * Modify previous solution: delete useless codes
 * 
 * 
 * https://leetcode.com/problems/binary-tree-paths/
 * @author caos1
 * Key Points:
 *     1. Pay attention to recursive end, not to null, to leaf node
 */
public class BinaryTreePaths {
    @Test
    public void abc() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n2.right = n3;
        List<String> result = anotherMethod(n1);
        for (String s : result) {
            System.out.println(s);
        }
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new LinkedList<String>();
        }
        if (root.left == null && root.right == null) {
            return new LinkedList<String>(Arrays.asList(String.valueOf(root.val)));
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        right.addAll(left);
        List<String> result = new LinkedList<String>();
        for (String s : right) {
            result.add(String.valueOf(root.val) + "->" + s);
        }
        return result;
    }

    public List<String> anotherMethod(TreeNode root) {
        List<String> result = new LinkedList<String>();
        binaryTreePaths(root, "", result);
        return result;
    }

    public void binaryTreePaths(TreeNode root, String currentPath, List<String> result) {
        if (root == null) {
            return;
        }
        String addRootPath = currentPath.isEmpty() ? "" + root.val : currentPath + "->" + root.val;
        if (root.left == null && root.right == null) {
            result.add(addRootPath);
            return;
        }
        if (root.left != null) {
            binaryTreePaths(root.left, addRootPath, result);
        }
        if (root.right != null) {
            binaryTreePaths(root.right, addRootPath, result);
        }
    }
}
