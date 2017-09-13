package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Revisit on 9/5/2017, modify API to use generic and return value when pop
 * 
 * Comment out redundant codes (no need to move all elements to one queue) 
 * 
 * 
 * https://leetcode.com/problems/implement-stack-using-queues/
 * @author caos1
 * Key Points:
 *     1. Push: to q1
 *     2: Pop: move elements from between 2 queues, left last one, remove
 *     3: Top: move elements from between 2 queues, record last one and return. NOTE: keep all elements in one queue
 *     to avoid possible data order chaos
 *     4. Empty: only return true when both queues are empty
 */
public class MyStack<T> {
    Queue<T> q1 = new LinkedList<>();
    Queue<T> q2 = new LinkedList<>();
    // Push element x onto stack.
    public void push(T x) {
        q1.add(x);
    }

    // Removes the element on top of the stack.
    public T pop() {
        if (!q1.isEmpty()) {
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
            return q1.remove();
        } else {
            while(q2.size() > 1) {
                q1.add(q2.remove());
            }
            return q2.remove();
        }
    }

    // Get the top element.
    public T top() {
        if (!q1.isEmpty()) {
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
            return q1.peek();
//            q2.add(q1.remove());
        } else {
            while(q2.size() > 1) {
                q1.add(q2.remove());
            }
            return q2.peek();
//            q1.add(q2.remove());
        }
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
