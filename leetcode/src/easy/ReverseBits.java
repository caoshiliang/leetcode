package easy;

/**
 * Revisit on 9/11/2017
 * 
 * Add a new solution without an array, which is to say, we get a bit once
 * and use it right that time.
 * 
 * https://leetcode.com/problems/reverse-bits/
 * @author caos1
 * Key Points:
 *     1. How to get bits array
 *     2. How to convert bits array to an integer
 */
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE + 2));
    }
    public int reverseBits(int n) {
        int[] bits = new int[32];
        for (int i = 0; i < 32; i ++) {
            int mask = 1 << i;
            bits[i] = (n & mask) == 0 ? 0 : 1;
        }
        int count = 0;
        for (int i = 0; i < 32; i ++) {
            count = count * 2 + bits[i];
        }
        return count;
    }

    /**
     * Simplest solution, no more space, constant time
     * @param n
     * @return
     */
    public int another(int n) {
        int count = 0;
        for (int i = 0; i < 32; i ++) {
            count = ((count << 1) | ((n & (1 << i)) == 0 ? 0 : 1));
        }
        return count;
    }
}
