package easy;

import models.ListNode;

/**
 * Revisit on 9/11/2017
 * 
 * 
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * @author silent
 * Key points:
 * 1. Add a new head, which is convenient for operating
 * 2. Really need to calculate with pen about how to point nodes
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nHead = new ListNode(0);
        nHead.next = head;
        ListNode p = nHead;
        while(p.next != null && p.next.next != null) {
            ListNode q = p.next.next;
            ListNode tmp = p.next;
            p.next = p.next.next;
            tmp.next = q.next;
            q.next = tmp;
            p = tmp;
        }
        return nHead.next;
    }
    
    /**
     * Add a new solution with a new head
     * @param head
     * @return
     */
    public ListNode another(ListNode head) {
        ListNode nHead = new ListNode(0);
        ListNode p = head;
        ListNode trail = nHead;
        while (p != null && p.next != null) {
            ListNode save = p.next.next;
            trail.next = p.next;
            p.next.next = p;
            p.next = null;
            p = save;
            trail = trail.next.next;
        }
        if (p != null) {
            trail.next = p;
        }
        return nHead.next;
    }

}
