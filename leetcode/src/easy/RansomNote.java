package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Revisit on 9/9/2017
 * 
 * Simplify the solution deleting some lines
 * 
 * 
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
            tmp.put(c, tmp.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i ++) {
            char c = ransomNote.charAt(i);
            int num = tmp.getOrDefault(c, 0);
            if (num == 0) {
                return false;
            }
            tmp.put(c, num - 1);
        }
        return true;
    }
}
