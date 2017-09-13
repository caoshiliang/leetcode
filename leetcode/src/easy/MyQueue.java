package easy;

import java.util.Stack;

/**
 * Revisit on 9/5/2017
 * 
 * 
 * 
 * Modify the interface of pop, make it return value;
 * Using generic
 * 
 * A queue implemented using 2 stack, not a leetcode question
 * @author caos1
 *
 */
class MyQueue<T> {
    Stack<T> s1 = new Stack<>();
    Stack<T> s2 = new Stack<>();
    // Push element x to the back of queue.
    public void push(T x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public T pop() {
        if (!s2.isEmpty()) {
            return s2.pop();
        }
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    // Get the front element.
    public T peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
