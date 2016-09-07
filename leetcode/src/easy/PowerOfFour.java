package easy;
/**
 * https://leetcode.com/problems/power-of-four/
 * @author silent
 * Soutions:
 * 1. Using while loop to detect if it has non-4 factor, return false if it has.
 * 2. Another way: the bit array character: with double zeros after 1
 **/
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if (num < 1) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        while (num != 1) {
            if (num % 4 != 0) {
                return false;
            }
            num /= 4;
        }
        return true;
    }
    public boolean isPowerOfFourAnother(int num) {
        return Integer.toBinaryString(num).matches("1(00)*");
    }
}
