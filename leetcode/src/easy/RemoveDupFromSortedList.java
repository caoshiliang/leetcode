package easy;

import models.ListNode;

/**
 * Revisit on 9/11/2017
 * 
 * Key points: check the boundary condition carefully, to make it cover all case
 * and as simple as possible.
 * 
 * 
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * @author silent
 * Key points:
 *     1. Inner while loop is necessary, which doesn't means the time complexity is O(n^2), it's still O(n)
 *     2. Pay attention to check null pointer in inner loop, which could always be missed.
 */
public class RemoveDupFromSortedList {
    public ListNode deleteDuplicate(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head.next;
        while (q != null) {
            while (p.val == q.val) {
                q = q.next;
                p.next = q;
                if (q == null) {
                    return head;
                }
            }
            p = p.next;
            q = q.next;
        }
        return head;
    }

    /**
     * New added solution with less lines and clearer logic
     * @param head
     * @return
     */
    public ListNode another(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        while (p != null) {
            ListNode q = p.next;
            while (q != null && q.val == p.val) {
                q = q.next;
            }
            p.next = q;
            p = q;
        }
        return head;
    }
}
