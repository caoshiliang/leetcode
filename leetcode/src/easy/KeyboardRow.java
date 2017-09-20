/**
 * Created on Sep 19, 2017 4:41:59 PM
 */
package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/keyboard-row/description/
 * @author caos1
 *
 *
 * Just coding
 */
public class KeyboardRow {
    private static final Set<Character> ROW1;
    private static final Set<Character> ROW2;
    private static final Set<Character> ROW3;
    static {
        ROW1 = new HashSet<>();
        ROW1.addAll(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
        ROW2 = new HashSet<>();
        ROW2.addAll(Arrays.asList('a','s','d','f','g','h','j','k','l'));
        ROW3 = new HashSet<>();
        ROW3.addAll(Arrays.asList('z','x','c','v','b','n','m'));
    }
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            Set<Character> s = null;
            boolean oneRow = true;
            for (int i = 0; i < word.length(); i ++) {
                char c = Character.toLowerCase(word.charAt(i));
                if (s == null) {
                    s = getRow(c);
                } else if (!s.contains(c)) {
                    oneRow = false;
                    break;
                }
            }
            if (oneRow) {
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }
    private Set<Character> getRow(char c) {
        if (ROW1.contains(c)) {
            return ROW1;
        } else if (ROW2.contains(c)) {
            return ROW2;
        } else {
            return ROW3;
        }
    }
}
