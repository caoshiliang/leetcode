package easy;
/**
 * https://leetcode.com/problems/ugly-number/
 * @author silent
 * Key points:
 *     1. Don't try to compose the number thoroughly, compose it with 2/3/5 until
 *     it's composed finally (ugly), or blocked (not ugly);
 *     2. Trap is the non-positive (not ugly) input and 1 (ugly).
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
        return true;
    }
}
