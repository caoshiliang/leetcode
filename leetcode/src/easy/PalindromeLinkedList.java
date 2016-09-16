package easy;

import models.ListNode;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * @author caos1
 * Key Points: 
 *     1. 2 pointers
 *     2. Cut the linked list from the middle, reverse the first half, then compare the 2 linked list
 *     return true if they're the same;
 *     3. Pay attention if the length of linked list is odd, need to omit the middle element
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        int length = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            length ++;
        }
        ListNode newHead = new ListNode(1);
        ListNode q = newHead;
        p = head;
        int i = 0;
        while (i < length / 2) {
            ListNode next = p.next;
            p.next = q.next;
            q.next = p;
            p = next;
            i ++;
        }
        q = newHead.next;
        if (length % 2 != 0) {
            p = p.next;
        }
        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }
}
