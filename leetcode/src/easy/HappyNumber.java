package easy;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * https://leetcode.com/problems/happy-number/
 * @author silent
 * Key points: Endlessly calcuating means there's a loop in it, which means
 * there's must be duplicate element if you record all intermediate numbers.
 * Another thought: Most people could come up with the solution to use hashset
 * But in some cases, time is not bottleneck, we want less space occupied, in which
 * case, we could introduce Floyd Circle Detection (1 step, 2 steps, meet means circle)
 */
public class HappyNumber {
    @Test
    public void abc() {
        isHappy(3);
    }
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<Integer>();
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (s.contains(sum)) {
                return false;
            } else {
                s.add(sum);
            }
            n = sum;
        }
        return true;
    }
}
