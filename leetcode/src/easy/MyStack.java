package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 * @author caos1
 * Key Points:
 *     1. Push: to q1
 *     2: Pop: move elements from between 2 queues, left last one, remove
 *     3: Top: move elements from between 2 queues, record last one and return. NOTE: keep all elements in one queue
 *     to avoid possible data order chaos
 *     4. Empty: only return true when both queues are empty
 */
public class MyStack {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!q1.isEmpty()) {
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
            q1.remove();
        } else {
            while(q2.size() > 1) {
                q1.add(q2.remove());
            }
            q2.remove();
        }
    }

    // Get the top element.
    public int top() {
        int result;
        if (!q1.isEmpty()) {
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
            result = q1.peek();
            q2.add(q1.remove());
        } else {
            while(q2.size() > 1) {
                q1.add(q2.remove());
            }
            result = q2.peek();
            q1.add(q2.remove());
        }
        return result;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
