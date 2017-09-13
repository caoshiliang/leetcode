package easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Revisited on 9/5/2017:
 * 
 * 
 * Add a new method using LinkedHashMap, which is a FIFO HashMap implementation,
 * so that when getting the elements, that are inserted along the position, the first out qualified
 * element position (need another map) can be returned directly.
 * 
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * @author silent
 * Solution: uses 2 maps to contains index and appearing time.
 */
public class FirstUniqueCharacter {
    public int anotherMethod(String s) {
        Map<Character, Integer> m = new LinkedHashMap<>();
        Map<Character, Integer> indice = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            m.put(c, m.getOrDefault(c, 0) + 1);
            if (!indice.containsKey(c)) {
                indice.put(c, i);
            }
        }
        for (Entry<Character, Integer> en : m.entrySet()) {
            if (en.getValue() == 1) {
                return indice.get(en.getKey());
            }
        }
        return -1;
    }
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
