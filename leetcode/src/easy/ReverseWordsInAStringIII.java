/**
 * Created on Sep 19, 2017 6:12:21 PM
 */
package easy;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 * 
 * 
 * Key Points:
 * 1. Reverse words in a String, a classic question
 * 2. First, need to recognize a word, then reverse; then append to builder.
 * 
 * 
 * 
 * @author caos1
 *
 */
public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {

        if (s.length() < 2) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0, j = 1; i < j && j <= s.length();) {
            while(j < s.length() && s.charAt(j) != ' ') j ++;
            builder.append(reverse(s.substring(i, j))).append(' ');
            i = j + 1;
            j = i + 1;
        }

        return builder.substring(0, builder.length() - 1);
    }

    private String reverse(String s) {
        StringBuilder builder = new StringBuilder(s.length());
        for (int i = s.length() - 1; i >= 0; i --) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
