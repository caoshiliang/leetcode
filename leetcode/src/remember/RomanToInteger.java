package remember;
/**
 * https://leetcode.com/problems/roman-to-integer/
 * @author silent
 * I : 1
 * V : 5
 * X : 10
 * L : 50
 * C : 100
 * D : 500
 * M : 1000
 * I/X/C can be minused to get a single digit
 * So, the keypoint is to identify if it is to add or to minus when I/X/C appears
 * 
 * Scan direction of this method is from back-end to front-end
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
            case 'I':
                res += (res >= 5 ? -1 : 1);
                break;
            case 'V':
                res += 5;
                break;
            case 'X':
                res += 10 * (res >= 50 ? -1 : 1);
                break;
            case 'L':
                res += 50;
                break;
            case 'C':
                res += 100 * (res >= 500 ? -1 : 1);
                break;
            case 'D':
                res += 500;
                break;
            case 'M':
                res += 1000;
                break;
            }
        }
        return res;
    }
}
