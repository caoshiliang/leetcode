package easy;
/**
 * Revisited on 9/5/2017: essentially, this is a conversion problem between
 * 26-scale number to decimal number.
 * 
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
