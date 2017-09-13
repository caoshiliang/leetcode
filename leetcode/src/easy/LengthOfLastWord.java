package easy;
/**
 * Revisited on 9/5/2017
 * 
 * Add another solution, using raw codes, not Java API
 * 
 * when encountering whitespace, clear acc; continue; otherwise, accumulate.
 * One exception it can't handle is that when there're multiple whitespaces in the end.
 * This case, the last length is cleared, and no new word is counted, and we're actually supposed
 * to return the length of word before whitespace, thus need to save that one in this case.
 * 
 * 
 * https://leetcode.com/problems/length-of-last-word/
 * @author caos1
 *
 */
public class LengthOfLastWord {
    
    public int anotherWay(String s) {
        int save = 0;
        int acc = 0;
        for (int i = 0; i < s.length(); i ++) {
            char si = s.charAt(i);
            if (si == ' ') {
                if (acc != 0) {
                    save = acc;
                }
                acc = 0;
                continue;
            }
            acc ++;
        }
        return acc == 0 ? save : acc;
    }
    // via Java API
    public int lengthOfLastWord(String s) {
        String[] parts = s.trim().split(" ");
        return parts[parts.length - 1].trim().length();
    }
}
