package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * @author silent
 * Solution: uses 2 maps to contains index and appearing time.
 */
public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        Map<Character, Integer> index = new HashMap<>();
        Map<Character, Integer> times = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (!times.containsKey(c)) {
                times.put(c, 0);
            }
            times.put(c, times.get(c) + 1);
            if (!index.containsKey(c)) {
                index.put(c, i);
            }
        }
        int result = Integer.MAX_VALUE;
        for (java.util.Map.Entry<Character, Integer> entry : times.entrySet()) {
            if (entry.getValue() != 1) {
                continue;
            }
            int position = index.get(entry.getKey());
            if (position < result) {
                result = position;
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
