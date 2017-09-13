package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Revisit on 9/11/2017
 * 
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 * 
 * @author silent
 * Key points:
 * 1. 2 pointers from front and end starting, swap until they cross
 * 2. (Trap) Don't forget to move pointers one step on after swapping, so to avoid dead loop
 */
public class ReverseVowels {
    @Test
    public void test() {
        System.out.println(reverseVowels("Hello"));
    }
    public String reverseVowels(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder builder = new StringBuilder(s);
        int low = 0;
        int high = builder.length() - 1;
        while (low < high) {
            // Remember to check the boundary
            while (!isVowel(builder.charAt(low)) && low < high) {
                low ++;
            }
            while (!isVowel(builder.charAt(high)) && low < high) {
                high --;
            }
            if (low >= high) {
                break;
            }
            char tmp = builder.charAt(low);
            builder.setCharAt(low, builder.charAt(high));
            builder.setCharAt(high, tmp);
            
            // REMEMBER to increase the counter
            low ++;
            high --;
        }
        return builder.toString();
    }

    public String another(String s) {
        StringBuilder builder = new StringBuilder(s);
        int low = 0, high = builder.length() - 1;
        while (low < high) {
            while(!isVowel(builder.charAt(low))) {
                low ++;
            }
            while(!isVowel(builder.charAt(high))) {
                high --;
            }
            if (low < high) {
                char tmp = builder.charAt(low);
                builder.setCharAt(low, builder.charAt(high));
                builder.setCharAt(high, tmp);
                low ++;
                high --;
            }
        }
        return builder.toString();
    }

    private boolean isVowel(char c) {
        Set<Character> s = new HashSet<Character>(Arrays.asList('a', 'e', 'i',
                'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        return s.contains(c);
    }
}
