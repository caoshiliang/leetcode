package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/
 * @author caos1
 * Key Points:
 *     1. No more tricks, still 2 maps to record the mapping relations
 *     2. Pay attention the boundary check that the length of pattern string and second
 *     parameter string parts is not equal (should return false in this case)
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] parts = str.trim().split(" ");
        if (pattern.length() != parts.length) {
            return false;
        }
        Map<Character, String> m1 = new HashMap<>();
        Map<String, Character> m2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i ++) {
            char c = pattern.charAt(i);
            String part = parts[i];
            if (m1.containsKey(c)) {
                if (!m1.get(c).equals(part)) {
                    return false;
                }
            } else {
                m1.put(c, part);
            }
            if (m2.containsKey(part)) {
                if (m2.get(part) != c) {
                    return false;
                }
            } else {
                m2.put(part, c);
            }
        }
        return true;
    }
}
