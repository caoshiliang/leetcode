package easy;

import models.ListNode;
/**
 * https://leetcode.com/problems/reverse-linked-list/
 * @author silent
 */
public class ReverseLinkedList {

    public ListNode reverseOldStyle(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode tmp = null;
        ListNode p = node;
        ListNode q = node.next;
        while (q != null) {
            p.next = tmp;
            tmp = p;
            p = q;
            q = q.next;
        }
        // till now, p points to the last element but not linked to the reversed link without it
        p.next = tmp;
        return p;
    }
    /*
     * Head Insert Method
     */
    public ListNode reverseIteritively(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode head = new ListNode(1);
        while(node != null) {
            ListNode tmp = node.next;
            node.next = head.next;
            head.next = node;
            node = tmp;
        }
        return head.next;
    }
    /*
     * Recursive way
     */
    public ListNode reverseList(ListNode  node) {
        if (node == null) {
            return null;
        }
        ListNode sub = reverseList(node.next);
        if (sub == null) {
            return node;
        }
        ListNode head = sub;
        while (sub.next != null) {
            sub = sub.next;
        }
        node.next = null;
        sub.next = node;
        return head;
    }
}
