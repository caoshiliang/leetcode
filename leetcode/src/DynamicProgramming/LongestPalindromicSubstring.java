package DynamicProgramming;

/**
 * Revisit on 9/13/2017
 * 
 * When designing the DP using data structure, one thing keep in mind:
 * Should decide what element to store in the array
 * With respect to this case, we could store a boolean to indicate if the
 * corresponding string is palindrome or not.
 * 
 * And if this String is, then save the row and col (a.k.a. start and end
 * of the String) for returning result finally
 * 
 * 
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * 
 * @author caos1
 *
 * Key points:
 *  1. induction formula;
 *  2. Iterative direction.
 *  
 *  
 */
public class LongestPalindromicSubstring {
    
public static void main(String[] args) {
    int a = 1;
    System.out.println(Integer.toBinaryString(~1));
    System.out.println(~a);
}
public String longestPalindrom(String s) {
        
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        char[] cs = s.toCharArray();
        int len = s.length();
        boolean[][] isPal = new boolean[len][len];

        int start = 0, end = 0;

        for (int i = len - 1; i >= 0; i --) {
            for (int j = len - 1; j >= i; j --) {
                if (i == j || (i + 1 == j && cs[i] == cs[j]) || (cs[i] == cs[j] && isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                    if (j - i > end - start) {
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public String another(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return s;
        }
        int start = 0, end = 0, sLen = s.length();
        // Element of (i, j) position indicates whether s.subString(i, j + 1) is palindrome
        boolean[][] isPal = new boolean[sLen][sLen];
        for (int i = sLen - 1; i >= 0; i --) {
            for (int j = i; j < sLen; j ++) {
                if (i == j || (i + 1 == j && s.charAt(i) == s.charAt(j)) || (isPal[i + 1][j - 1] && s.charAt(i) == s.charAt(j))) {
                    isPal[i][j] = true;
                    if (j - i > end - start) {
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

}
