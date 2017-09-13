package easy;


/**
 * Revisited on 9/5/2017, it's more like a mathematics problem
 * 
 * https://leetcode.com/problems/integer-replacement/
 * 
 * @author caos1
 *
 * Key Points:
 *     1. To save stack space, use iterative method, not the recursive one;
 *     2. To save time, use bit shifting instead of dividing
 */
public class IntegerReplacement {
    public int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) { // if even
                n >>>= 1;
            } else if (((n >>> 1) & 1) == 0 || n == 3) { // if end with 10 or is 11
                n --;
            } else { // if end with 11, plus 1 is more efficient
                n ++;
            }
            count++;
        }
        return count;
    }
}
