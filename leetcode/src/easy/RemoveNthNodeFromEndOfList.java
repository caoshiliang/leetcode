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
}
 