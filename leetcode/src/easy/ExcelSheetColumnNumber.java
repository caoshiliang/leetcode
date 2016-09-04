package easy;
/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 * @author silent
 * 26-scale to decimal number
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        if (s == null || s.isEmpty()) {
            return -1; // invalid number
        }
        int number = 0;
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            number = number * 26 + c - 'A' + 1;
        }
        return number;
    }
}
