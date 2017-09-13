package easy;

import java.util.Arrays;

/**
 * 
 * Revisited on 9/9/2017
 * 
 * Add another solution, adding in place
 * Key point: keep tracking overflow, when there's no, could break immediately (go on is more convenient
 * when not adding in place, as left elements still need copying)
 * 
 * 
 * https://leetcode.com/problems/plus-one/
 * @author silent
 * Key Points:
 *    1. Need another array to store result, which size is bigger of 1, in case of overflow
 *    2. If non-carryon detected, break and return: remember not to add carry-on bit.
 *    Otherwise, set carry-on bit 1, then return
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        System.arraycopy(digits, 0, result, 1, digits.length);
        boolean plus = true;
        for (int i = digits.length - 1; i >= 0; i --) {
            if (!plus) {
                break;
            }
            int tmp = digits[i] + 1;
            if (tmp < 10) {
                result[i + 1] = tmp;
                plus = false;
            } else {
                result[i + 1] = tmp % 10;
            }
        }
        if (plus) {
            result[0] = 1;
            return result;
        } else {
            return Arrays.copyOfRange(result, 1, result.length);
        }
    }
    
    public int[] another(int[] digits) {
        int overflow = 1;
        for (int i = digits.length - 1; i >= 0; i --) {
            int tmp = digits[i] + overflow;
            if (tmp < 10) {
                digits[i] = tmp;
                overflow = 0;
                break;
            }
            digits[i] = tmp - 10;
        }
        if (overflow == 0) {
            return digits;
        } else {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = 1;
            return result;
        }
    }
}
