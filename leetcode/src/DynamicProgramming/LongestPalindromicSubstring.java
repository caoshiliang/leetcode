package DynamicProgramming;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * 
 * @author caos1
 *
 * Key points:
 *  1. induction formula;
 *  2. Iterative direction.
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

}
