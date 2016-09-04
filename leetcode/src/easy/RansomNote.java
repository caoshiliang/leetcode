package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/ransom-note/
 * @author silent
 * Solution: build a map to store intermediate result
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null) {
            return false;
        }
        if (ransomNote == null || ransomNote.isEmpty()) {
            return true;
        }
        Map<Character, Integer> tmp = new HashMap<>();
        for (int i = 0; i < magazine.length(); i ++) {
            char c = magazine.charAt(i);
            if (!tmp.containsKey(c)) {
                tmp.put(c, 0);
            }
            tmp.put(c, tmp.get(c) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i ++) {
            char c = ransomNote.charAt(i);
            if (!tmp.containsKey(c) || tmp.get(c) <= 0) {
                return false;
            }
            tmp.put(c, tmp.get(c) - 1);
        }
        return true;
    }
}
