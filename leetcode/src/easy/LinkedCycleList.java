package easy;

import models.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle
 * @author silent
 * Solution: 2 pointers, 1 is faster and the other is slower
 */
public class LinkedCycleList {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return false;
            } else {
                fast = fast.next.next;
            }
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
