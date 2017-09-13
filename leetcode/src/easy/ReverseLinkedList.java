package easy;

import models.ListNode;
/**
 * Revisit on 9/11/2017, Traditional way of reverse a linked list
 * 
 * Maintain a new linked list (null at beginning), then take first element of current
 * linked list and append it to the head of the new one. Finally, remember to append last
 * element, as in the loop the last has no chance to be appended.
 * 
 * 
 * 
 * https://leetcode.com/problems/reverse-linked-list/
 * @author silent
 */
public class ReverseLinkedList {

    public ListNode reverseOldStyle(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode trail = null; // hold head of new linked list
        ListNode p = node;
        ListNode q = node.next;
        while (q != null) {
            p.next = trail;
            trail = p;
            p = q;
            q = q.next;
        }
        // till now, p points to the last element but not linked to the reversed link without it
        p.next = trail;
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
