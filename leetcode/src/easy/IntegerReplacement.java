package easy;
/**
 * https://leetcode.com/problems/integer-replacement/
 * @author caos1
 *
 */
public class IntegerReplacement {
    public int integerReplacement(int n) {
        if (n == 2 || n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return integerReplacement(n / 2) + 1;
        } else {
            int minus = integerReplacement(n - 1) + 1;
            int plus = integerReplacement(n + 1) + 1;
        }
    }
}
