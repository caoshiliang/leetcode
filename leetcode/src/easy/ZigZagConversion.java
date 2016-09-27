package easy;

import org.junit.Test;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * @author caos1
 * Key Points:
 *     1. Draw a zigzag line and calcuate the positions first
 */
public class ZigZagConversion {
    @Test
    public void abc() {
        System.out.println(convert("paypalishiring", 3));
    }
    public String convert(String s, int numRows) {
        if (s.length() < 3) {
            return s;
        }
        if (numRows == 1) {
            return s;
        }
        int length = s.length();
        StringBuilder builder =  new StringBuilder(length);
        int leap = (numRows << 1) - 2;
        for (int i = 0; i < numRows; i ++) {
            for (int j = i; j < length; j += leap) {
                builder.append(s.charAt(j));
                if (j % (numRows - 1) == 0) {
                    continue;
                }
                int add = (numRows - j % (numRows - 1) - 1) * 2; // core part
                if (j + add >= length) {
                    continue;
                }
                builder.append(s.charAt(j + add));
            }
        }
        return builder.toString();
    }
}
