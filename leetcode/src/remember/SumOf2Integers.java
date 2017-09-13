package remember;
/**
 * Revisited on 9/13/2017
 * 
 * https://leetcode.com/problems/sum-of-two-integers/
 * @author silent
 * Key Points:
 *     1. a^b is to save the bit after plus (not including carryon bit);
 *     2. (a&b)<<1 is to save carryon bit and put it one bit higher;
 *     3. Add original bits and carryon bits, is actually traditional plus theory
 *     4. Pay attention to the terminating condition: the carryon bit will became 0 soon
 */
public class SumOf2Integers {
    public int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getSum(a^b, (a&b) << 1);
    }
}
