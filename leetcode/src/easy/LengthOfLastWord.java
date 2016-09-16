package easy;
/**
 * https://leetcode.com/problems/length-of-last-word/
 * @author caos1
 *
 */
public class LengthOfLastWord {
    // via Java API
    public int lengthOfLastWord(String s) {
        String[] parts = s.trim().split(" ");
        return parts[parts.length - 1].trim().length();
    }
}
