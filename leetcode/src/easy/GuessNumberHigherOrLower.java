package easy;

import org.junit.Test;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 * @author caos1
 * Key Points:
 *     1. About algorithm, nothing new, just binary search
 *     2. Trap is, when 2 integers adding, overflow happens, need to convert to long to add
 */
public class GuessNumberHigherOrLower {
    @Test
    public void abc() {
        System.out.println(guessNumber(2126753390));
    }
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = (int)(((long)low + (long)high) / 2);
            int result = guess(mid);
            if (result == 0) {
                return mid;
            } else if (result > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // won't run to here
        return -1;
    }
    // mock
    private int guess(int n) {
        return 1702766719 - n;
    }
}
