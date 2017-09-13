package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Revisited on 9/5/2017, add another solution, NOTE one thing:
 * 
 * when compare Character and char, java will allow this on syntax, but when the Character is null
 * a NPE is thrown, instead of returning false
 * 
 * https://leetcode.com/problems/isomorphic-strings/
 * @author caos1
 * Key Points:
 *     1. Pay attention that we need 2 maps here, consider "aa" and "ab", will return true if using only one map
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
//        new IsomorphicStrings().anotherWay("ab", "aa");
        char a = 'c';
        Character b = null;
        if (b != a) {
            
        }
    }

    public boolean anotherWay(String s, String t) {
        Map<Character, Character> m0 = new HashMap<>();
        Map<Character, Character> m1 = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i ++) {
            char si = s.charAt(i);
            char ti = t.charAt(i);
            if (m0.containsKey(si) || m1.containsKey(ti)) {
                if (!new Character(ti).equals(m0.get(si)) || !new Character(si).equals(m1.get(ti))) {
                    return false;
                }
                continue;
            }
            m0.put(si, ti);
            m1.put(ti, si);
        }
        return true;
    }

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
