package easy;
/**
 * https://leetcode.com/problems/reverse-bits/
 * @author caos1
 * Key Points:
 *     1. How to get bits array
 *     2. How to convert bits array to an integer
 */
public class ReverseBits {
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
}
