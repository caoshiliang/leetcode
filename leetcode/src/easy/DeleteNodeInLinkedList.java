package easy;

import models.ListNode;

/**
 * Revisit on 9/5/2017
 * 
 * NOTE: the defect is this method can't delete last node of the link list.
 * 
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
