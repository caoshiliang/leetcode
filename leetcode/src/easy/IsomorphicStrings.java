package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 * @author caos1
 * Key Points:
 *     1. Pay attention that we need 2 maps here, consider "aa" and "ab", will return true if using only one map
 */
public class IsomorphicStrings {
    public boolean isIsomorphicStrings(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }
        Map<Character, Character> m1 = new HashMap<Character, Character>();
        Map<Character, Character> m2 = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i ++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (m1.containsKey(a)) {
                if (m1.get(a) != b) {
                    return false;
                }
            } else {
                m1.put(a, b);
            }
            if (m2.containsKey(b)) {
                if (m2.get(b) != a) {
                    return false;
                }
            } else {
                m2.put(b, a);
            }
        }
        return true;
    }
}
