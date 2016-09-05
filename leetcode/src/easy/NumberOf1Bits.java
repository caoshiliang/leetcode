package easy;

import org.junit.Test;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 * @author silent
 * Key point is to get all bits of the integer, of which the key point
 * is to get a mask via bit shifting
 */
public class NumberOf1Bits {
    @Test
    public void abc() {
        System.out.println(hammingWeight(8));
    }
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i ++) {
            int mask = 1<<i;
            if ((n & mask) != 0) {
                count ++;
            }
        }
        return count;
    }
}
