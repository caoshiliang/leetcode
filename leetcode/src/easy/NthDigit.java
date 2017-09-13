package easy;

import org.junit.Test;

/**
 * 
 * Visited on 9/5/2017
 * 
 * Really subtle thing ... especially when getting the number and bit order from left
 * 
 * Need to be careful
 * 
 * https://leetcode.com/problems/nth-digit/
 * @author silent
 * Main Thought: Get the number and get the order of this bit in the number
 */
public class NthDigit {
    @Test
    public void abc() {
        System.out.println(findNthDigit(12));
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
        long left = n % bits;
        return String.valueOf(number).charAt((int)left - 1) - 48;
    }
}
