package easy;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
/**
 * Revisit on 9/4/2017, bulls are kind of cows
 * record bulls separately, and calculate all cows, finally remove mixed bulls.
 * 
 * https://leetcode.com/problems/bulls-and-cows/
 * @author caos1
 * Key Points:
 *     1. Understand the meaning of the problem first
 *     2. All overlap chars - chars overlapping in same position (bulls) = cows
 */
public class BullsAndCows {
    @Test
    public void abc() {
        System.out.println(getHint("1807", "7810"));
    }
    public String getHint(String secret, String guess) {
        if (secret.isEmpty() && secret.isEmpty()) {
            return "0A0B";
        }
        int bulls = 0;
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < secret.length(); i ++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls ++;
            }
            if (!m.containsKey(s)) {
                m.put(s, 0);
            }
            m.put(s, m.get(s) + 1);
        }
        int cows = 0;
        for (int i = 0; i < guess.length(); i ++) {
            char g = guess.charAt(i);
            if (!m.containsKey(g)) {
                continue;
            }
            int left = m.get(g);
            if (left == 1) {
                m.remove(g);
            } else {
                m.put(g, m.get(g) - 1);
            }
            cows ++;
        }
        cows -= bulls;
        return String.format("%sA%sB", bulls, cows);
    }
}
