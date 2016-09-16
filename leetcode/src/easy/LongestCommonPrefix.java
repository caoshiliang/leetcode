package easy;
/**
 * https://leetcode.com/problems/longest-common-prefix/
 * @author caos1
 * Key Points:
 *     1. Check all strings, from 0 to ...
 *     2. Pay attention to the indexes number, keep a clear mind
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int i = 0;
        while (true) {
            if (strs[0].length() == i) {
                return strs[0];
            }
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (strs[j].length() == i) {
                    return strs[j];
                }
                if (strs[j].charAt(i) != c) {
                    return strs[j].substring(0, i);
                }
            }
            i ++;
        }
    }
}
