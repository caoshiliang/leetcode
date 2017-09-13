package easy;


/**
 * https://leetcode.com/problems/reverse-string/description/
 * @author caos1
 *
 */
public class ReverseString {
    public static void main(String[] args) {
        System.out.println(new ReverseString().reverseString("abc"));
    }
    public String reverseString(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length / 2; i ++) {
            char tmp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = tmp;
        }
        return new String(array);
    }

    /**
     * New solution: O(n) time and constant space
     * @param s
     * @return
     */
    public String another(String s) {
        StringBuilder builder = new StringBuilder(s.length());
        for (int i = s.length() - 1; i >= 0; i --) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
