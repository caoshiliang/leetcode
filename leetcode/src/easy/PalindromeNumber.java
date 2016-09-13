package easy;

import org.junit.Test;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author silent
 * Key Points:
 *    1. No allow for extra space, so bits should not be stored;
 *    2. Use bits to formulate another number (reverse version) and prepare.
 *    3. Negative numbers are not palindrome number
 */
public class PalindromeNumber {
    @Test
    public void abc() {
        System.out.println(isPalindrom(0));
    }
    
    public boolean isPalindrom(int x) {
        if (x < 0) {
            return false;
        }
        int save = x;
        int bit = 0;
        while (x != 0) {
            bit = bit * 10 + x % 10;
            x /= 10;
        }
        return bit == save;
    }
}
