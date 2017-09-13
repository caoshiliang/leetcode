package easy;
/**
 * Revisit on 9/5/2017
 * 
 * Add a new solution in which, the method of get common prefix is extractd, thus the logic is 
 * more clear
 * 
 * https://leetcode.com/problems/longest-common-prefix/
 * @author caos1
 * Key Points:
 *     1. Check all strings, from 0 to ...
 *     2. Pay attention to the indexes number, keep a clear mind
 */
public class LongestCommonPrefix {
    
    public String longestCommonPrefixAnotherWay(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i ++) {
            prefix = longestPrefix(prefix, strs[i]);
        }
        return prefix;
    }
 
    public String longestPrefix(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }
        int len = s.length() < t.length() ? s.length() : t.length();
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < len; i ++) {
            if (s.charAt(i) != t.charAt(i)) {
                break;
            }
            prefix.append(s.charAt(i));
        }
        return prefix.toString();
    }

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
