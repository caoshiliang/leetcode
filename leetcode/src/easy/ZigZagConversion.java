package easy;

import org.junit.Test;

/**
 * Revisit on 9/11/2017
 * 
 * Key points: the iterator steps
 * 
 * Be cautious: if the rows is 1, then the leap is 0, which will result dead loop
 * time and space will exceed the limitation. The answer will never be got.
 * 
 * https://leetcode.com/problems/zigzag-conversion/
 * @author caos1
 * Key Points:
 *     1. Draw a zigzag line and calculate the positions first
 */
public class ZigZagConversion {
//    @Test
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

    @Test
    public void test() {
        System.out.println(another("A", 1));
    }
    public String another(String s, int rows) {
        if (rows == 1) {
            return s;
        }
        StringBuilder builder = new StringBuilder(s.length());
        int leap = (rows - 1) * 2;
        for (int i = 0; i < rows; i ++) {
            for (int j = i; j < s.length(); j += leap) {
                builder.append(s.charAt(j));
                if (i == 0 || i == rows - 1) {
                    continue; // no more to append
                }
                if ((rows - i - 1) * 2  + j < s.length()) {
                    builder.append(s.charAt((rows - i - 1) * 2 + j));
                }
            }
        }
        return builder.toString();
    }
}
