package pickone;

/**
 * Are you fucking kidding me?
 * https://leetcode.com/problems/string-to-integer-atoi/description/#
 * @author caos1
 *
 * Key points:
 *  Just try and try and try until all test cases are covered;
 */
public class StringToInteger {

    public static void main(String[] args) {
//        System.out.println(new StringToInteger().myAtoi("2147483648"));
        int a = 214748364;
        int b = a * 10 + 8;
        System.out.print((b - 8) / 10);
    }

    public int myAtoi(String str) {
        int sum = 0;
        int signal = 1;
        boolean metValidChar = false;
        for (int i = 0; i < str.length(); i ++) {
            char bit = str.charAt(i);
            if (bit == ' ') {
                if (metValidChar) {
                    return sum;
                }
                continue;
            }
            metValidChar = true;
            if (bit == '+' || bit == '-') {
                if (i < str.length() - 1 && (str.charAt(i + 1) == '-' || str.charAt(i + 1) == '+')) {
                    return 0;
                }
                if (bit == '-') {
                    signal = -1;
                }
                continue;
            }
            if (bit < '0' || bit > '9') {
                return sum * signal;
            }
            int prev = sum;
            sum *= 10;
            sum += bit - '0';
            if (sum < 0 || (sum - (bit - '0')) / 10 != prev) { //overflow case
                if (signal == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
        }
        return sum * signal;
    }
}
