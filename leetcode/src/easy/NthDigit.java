package easy;

import java.util.Stack;

import org.junit.Test;

/**
 * https://leetcode.com/problems/nth-digit/
 * @author silent
 * Main Thought: Get the number and get the order of this bit in the number
 */
public class NthDigit {
    @Test
    public void abc() {
        System.out.println(findNthDigit(1111111111));
    }
    public int findNthDigit(int n) {
        long base = 9;
        long bits = 1;
        while (n > base * bits) {
            n -= base * bits;
            base *= 10;
            bits ++;
        }
        long number = (n - 1) / bits + base / 9;
        long left = (n - 1) % bits;
        return String.valueOf(number).charAt((int)left) - 48;
    }
}
