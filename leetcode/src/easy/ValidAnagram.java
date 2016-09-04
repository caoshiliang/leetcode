package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/articles/valid-anagram/
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
            if (!m.containsKey(c)) {
                m.put(c, 0);
            }
            m.put(c, m.get(c) + 1);
        }
        for (int i = 0; i < t.length(); i ++) {
            char c = t.charAt(i);
            if (!m.containsKey(c)) {
                return false;
            }
            int left = m.get(c);
            if (left == 1) {
                m.remove(c);
            } else {
                m.put(c, left - 1);
            }
        }
        return m.isEmpty();
    }
}
