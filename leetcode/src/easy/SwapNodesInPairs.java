package easy;

import models.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * @author silent
 * Key points:
 * 1. Add a new head, which is convinient for operating
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
}
