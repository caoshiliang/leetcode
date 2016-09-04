package easy;

import models.ListNode;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * @author silent
 * Solution: copy next element's value to this one, delete next element
 * Not really delete current node in memory, just delete it from logic perspective
 */
public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
