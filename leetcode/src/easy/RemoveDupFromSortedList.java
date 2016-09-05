package easy;

import models.ListNode;

/**
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
}
