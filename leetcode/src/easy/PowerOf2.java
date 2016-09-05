package easy;
/**
 * https://leetcode.com/problems/power-of-two/
 * @author silent
 *
 */
public class PowerOf2 {
    /**
     * Smart way use n&(n-1)
     * @param n
     * @return
     */
    public boolean isPowerOf2(int n) {
        if (n < 1) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        while (n != 1) {
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        }
        return true;
    }
}
