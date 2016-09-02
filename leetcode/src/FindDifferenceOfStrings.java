import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * https://leetcode.com/problems/find-the-difference/
 * @author silent
 *
 */
public class FindDifferenceOfStrings {
    /*
     * O(n) time complexity and O(n) space complexity
     */
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> m1 = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            char current = s.charAt(i);
            if (!m1.containsKey(current)) {
                m1.put(current, 1);
            }
            m1.put(current, m1.get(current) + 1);
        }
        Map<Character, Integer> m2 = new HashMap<>();
        for (int i = 0; i < t.length(); i ++) {
            char current = t.charAt(i);
            if (!m2.containsKey(current)) {
                m2.put(current, 1);
            }
            m2.put(current, m2.get(current) + 1);
        }
        for (java.util.Map.Entry<Character, Integer> entry : m2.entrySet()) {
            char key = entry.getKey();
            if (!m1.containsKey(key)) {
                return key;
            }
            int count = m1.get(key);
            if (entry.getValue() > count) {
                return key;
            }
        }
        // wont run to here
        return 'a';
    }
}
