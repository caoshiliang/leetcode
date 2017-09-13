package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Revisit on 9/11/2017
 * 
 * 
 * https://leetcode.com/problems/valid-anagram/
 * @author silent
 *
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == t) {
            return true;
        }
        if (s == null || t == null) {
           return false; 
        }
        if (s.isEmpty() ^ t.isEmpty()) {
            return false;
        }
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i ++) {
            char c = t.charAt(i);
            if (!m.containsKey(c)) {
                return false;
            }
            if (m.get(c) == 1) {
                m.remove(c);
            } else {
                m.put(c, m.get(c) - 1);
            }
        }
        return m.isEmpty();
    }
}
