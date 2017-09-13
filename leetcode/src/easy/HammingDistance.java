package easy;

/**
 * Revisited on 9/5/2017, XOR then compute numbers or 1.
 * 
 * 
 * https://leetcode.com/problems/hamming-distance/description/
 * @author caos1
 *
 *
 * XOR, then record all ones in the integer
 */
public class HammingDistance {

    public static void main(String[] args) {
        System.out.println(1 ^ 4);
    }
    public int hammingDistance(int x, int y) {
        int a = x ^ y;
        int count = 0;
        while (a != 0) {
            if (a % 2 != 0) {
                count ++;
            }
            a /= 2;
        }
        return count;
    }
}
