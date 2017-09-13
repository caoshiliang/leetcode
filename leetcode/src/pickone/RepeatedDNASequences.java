package pickone;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Revisited on 9/13/2017, The repeated strings could have overlap
 * 
 * 
 * https://leetcode.com/problems/repeated-dna-sequences/
 * @author caos1
 * Key Points:
 *     1. Use set to detect repeat
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.isEmpty() || s.length() < 11) {
            return new ArrayList<String>();
        }
        Set<String> result  = new HashSet<String>();
        Set<String> set = new HashSet<String>();
        for (int i = 0; i <= s.length() - 10; i ++) {
            String tmp = s.substring(i, i + 10);
            if (set.contains(tmp)) {
                result.add(tmp);
            } else {
                set.add(tmp);
            }
        }
        return new ArrayList<String>(result);
    }
}
