package easy;

import models.ListNode;

/**
 * Revisited on 9/5/2017, quite classic, first asked when interviewed in MSCI.
 * 
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * @author caos1
 * Key Points:
 *     1. How to judge if there're intersection between 2 linked list: same end;
 *     2. How to get the intersection node in O(n) time: count length, move concurrently
 *     Longer linked list jump n steps, n is the longer size. Then move concurrently at same speed
 *     Finally they will meet if intersection exists.
 */
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int sizeA = 1;
        ListNode p = headA;
        while(p.next != null) {
            p = p.next;
            sizeA ++;
        }
        
        int sizeB = 1;
        ListNode q = headB;
        while (q.next != null) {
            q = q.next;
            sizeB ++;
        }
        if (p != q) {
            return null;
        }
        p = headA;
        q = headB;
        if (sizeA > sizeB) {
            int i = sizeA - sizeB;
            while (i > 0) {
                p = p.next;
                i --;
            }
        } else {
            int i = sizeB - sizeA;
            while (i > 0) {
                q = q.next;
                i --;
            }
        }
        while (true) {
            if (p == q) {
                return p;
            }
            p = p.next;
            q = q.next;
        }
    }
}
