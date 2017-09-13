package easy;
/**
 * Revisited on 9/5/2017, NOTE: compare head, then compare body with Java API is easier
 * 
 * https://leetcode.com/problems/implement-strstr/
 * @author caos1
 * Key Points:
 *     1. Compare first char to decide if need to compare whole string
 *     2. Pay attention boundary checking codes in the beginning: haystack is shorter, needle is empty
 *     how to decide the end of loop (i)
 */
public class ImplementStr {
    public int strStr(String hayStack, String needle) {
        int lenH = hayStack.length();
        int lenN = needle.length();
        if (lenH < lenN) {
            return -1;
        }
        if (needle.isEmpty()) {
            return 0;
        }
        char head = needle.charAt(0);
        for (int i = 0; i <= lenH - lenN; i ++) {
            char c = hayStack.charAt(i);
            if (c != head) {
                continue;
            }
            if (hayStack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
