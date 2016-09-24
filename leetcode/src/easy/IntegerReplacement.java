package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/integer-replacement/
 * 
 * @author caos1
 *
 * Key Points:
 *     1. To save stack space, uset iterative method, not the recursive one;
 *     2. To save time, use bit hifting instead of dividing
 */
public class IntegerReplacement {
    public int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (((n >>> 1) & 1) == 0 || n == 3) {
                n --;
            } else {
                n ++;
            }
            count++;
        }
        return count;
    }
}
