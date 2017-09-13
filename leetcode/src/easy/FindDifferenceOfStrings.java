package easy;
import java.util.HashMap;
import java.util.Map;

/**
 * Revisited on 9/5/2017.
 * 
 * 
 * Key point is:
 * 
 *  XOR characteristics:
 *   1. XOR on same number even times, result is zero; odd times, result is this number itself;
 *   2. XOR with zero, result is the number itself;
 *   3. The XOR order doesn't matter.
 *   
 *   So with respect to this problem, just XOR all characters, and the single one will appear.
 * 
 * https://leetcode.com/problems/find-the-difference/
 * @author silent
 *
 */
public class FindDifferenceOfStrings {


    /**
     * New method found when revisiting this question
     */
    public char findTheDifferenceNew(String s, String t) {
        char a = 0;
        for (int i = 0; i < s.length(); i ++) {
            a ^= s.charAt(i);
        }
        for (int j = 0; j < t.length(); j ++) {
            a ^= t.charAt(j);
        }
        return a;
    }

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
