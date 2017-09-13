package easy;

import models.ListNode;

/**
 * Revisit on 9/5/2017
 * 
 * This solution could have multiple implementations.
 * 
 * Common practice:
 * Iterate elements in list; set end condition to != null
 * if loop ends, return false (cycle one won't end)
 * 2-step leaking requires checking if next element is null
 * 
 * 
 * https://leetcode.com/problems/linked-list-cycle
 * @author silent
 * Solution: 2 pointers, 1 is faster and the other is slower
 */
public class LinkedCycleList {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        for(ListNode slow = head, fast = head;;) {
            slow = slow.next;
            if (fast == null) {
                return false;
            } else if (fast.next == null) {
                return false;
            } else {
                fast = fast.next.next;
            }
            if (slow == fast) {
                return true;
            }
        }
    }
}
