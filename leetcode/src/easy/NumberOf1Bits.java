package easy;

import org.junit.Test;

/**
 * Revisited on 9/9/2017, add one more solution
 * 
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
    


    /**
     *  Solution using moding 2:
     *  - First convert to positive integer
     *  - Then calculate 1 bits
     *  - Finally return according to original positiveness
     * @param n1
     * @return
     */
    public int anotherSolution(int n) {
        int n1 = n < 0 ? ~n : n;
        int count = 0;
        while (n1 != 0) {
            if (n1 % 2 != 0) {
                count ++;
            }
            n1 /= 2;
        }
        return n < 0 ? 32 - count : count;
    }
}
