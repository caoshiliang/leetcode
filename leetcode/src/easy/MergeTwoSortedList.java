package easy;

import models.ListNode;
/**
 * Revisit on 9/5/2017, classic one, no more words
 * 
 * 
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * @author silent
 * Key points;
 * 1. Find a smaller one to put into list
 * 2. Put rest into list
 */
public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = new ListNode(1);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                p = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = l2;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            p.next = l1;
            p = l1;
            l1 = l1.next;
        }
        while (l2 != null) {
            p.next = l2;
            p = l2;
            l2 = l2.next;
        }
        return head.next;
    }
}
