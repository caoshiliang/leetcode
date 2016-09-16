package easy;

import org.junit.Test;
/**
 * https://leetcode.com/problems/count-and-say/
 * @author caos1
 * Key Points:
 *     1. Recursive way;
 *     2. Pay attention char to int is not directly, should minus 48 (because 1's ASCII code is 49)
 */
public class CountAndSay {
    @Test
    public void abc() {
        System.out.println(countAndSay(5));
    }
    public String countAndSay(int n) {
        if (n == 1) {
            return String.valueOf(1);
        }
        String last = countAndSay(n - 1);
        StringBuilder builder = new StringBuilder();
        int digit = last.charAt(0) - 48;
        int count = 1;
        for (int i = 1; i < last.length(); i ++) {
            int current = last.charAt(i) - 48;
            if (digit != current) {
                builder.append(count).append(digit);
                count = 1;
                digit = current;
            } else {
                count ++;
            }
        }
        builder.append(count).append(digit);
        return builder.toString();
    }
}
