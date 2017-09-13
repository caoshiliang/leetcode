package easy;

import models.ListNode;
/**
 * Revisited 0n 9/11/2017
 * 
 * 
 * https://leetcode.com/problems/remove-linked-list-elements/
 * @author caos1
 * Key Points:
 *     1. Skip all elements whose vals are equal with the given one.
 *     2. Use a new head to handle the case that given head should be deleted
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode (1);
        newHead.next = head;
        ListNode p = newHead;
        while (p != null) {
            ListNode q = p.next;
            while (q != null && q.val == val) {
                q = q.next;
            }
            p.next = q;
            p = p.next;
        }
        return newHead.next;
    }

    /**
     * New added solution
     * @param head
     * @param val
     * @return
     */
    public ListNode another(ListNode head, int val) {
        ListNode nHead = new ListNode(1);
        for (ListNode p = head, next = null, prev = nHead; p != null; p = next) {
            next = p.next;
            if (p.val != val) {
                prev.next = p;
                prev = p;
                prev.next = null;
            }
        }
        return nHead.next;
    }
}
