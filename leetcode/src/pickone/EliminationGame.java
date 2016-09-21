package pickone;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * https://leetcode.com/problems/elimination-game/
 * @author silent
 * Main Thought:
 *     Every round, keep track of left head and step and fromLeft (boolean) and remaining count.
 *     The regular pattern is that:
 *         a) left head: will increase step if fromLeft or fromRight while remaining count is even
 *         b) step: multiply 2 every time
 *         c) fromLeft: become opposite value every time
 *         d) remaining: divide by 2
 *      The law is return head when the remaining number is 1
 */
public class EliminationGame {
    @Test
    public void abc() {
        for (int i = 1; i < 100; i ++) {
            System.out.println("" + i + ": " + lastRemaining(i));
        }
    }
    public int lastRemaining(int n) {
        int remaining = n;
        int head = 1;
        int step = 1;
        boolean fromLeft = true;
        while (remaining > 1) {
            if (fromLeft || remaining % 2 != 0) {
                head += step;
            }
            remaining /= 2;
            step *= 2;
            fromLeft = !fromLeft;
        }
        return head;
    }
}
