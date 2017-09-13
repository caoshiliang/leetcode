package easy;

import models.ListNode;
/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * @author caos1
 * Key Points:
 *     1. Prepare a pointer which is before n + 1 steps of the traversing pointer (init it when counting step to n + 1)
 *     2. Pay attention to the case that the head node is removed 
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }
        ListNode p = head;
        ListNode q = null;
        int i = 0;
        while (p != null) {
            p = p.next;
            if (q != null) {
                q = q.next;
            }
            i ++;
            if (i == n + 1) {
                q = head;
            }
        }
        // if the to-be-removed node is head node
        if (i == n) {
            return head.next;
        }
        q.next = q.next.next;
        return head;
    }


    /**
     * New solution:
     * - Find (n + 1)-th element, and remove its next element
     * - Consider special cases:
     *   : Delete the last one (common logic could cover)
     *   : Delete the first one
     */
    public ListNode another(ListNode head, int n) {
        ListNode p = head;
        for (int i = 0; i < n; i ++) {
            p = p.next;
        }
        if (p == null) { // special case: remove the first
            return head.next;
        }
        p = p.next;
        ListNode trail = head;
        while (p != null) {
            trail = trail.next;
            p = p.next;
        }
        trail.next = trail.next.next;
        return head;
    }
}
 