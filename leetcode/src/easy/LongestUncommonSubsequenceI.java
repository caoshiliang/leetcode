package easy;


/**
 * Revisited on 9/5/2017
 * 
 * NOTE:
 * 
 * Uncommon subsequence: one's subsequence, but not another's
 * Which means, if 2 strings are not equal, the longer one itself is subsequence of itself, but not
 * the other's subsequence, thus we should return this one.
 * 
 * It's absolutely nothing related with LCS (longest common subsequence) problem.
 * 
 * 
 * https://leetcode.com/problems/longest-uncommon-subsequence-i/description/
 * It's more or less like a trick
 * https://discuss.leetcode.com/category/669
 * 
 * @author caos1
 *
 */
public class LongestUncommonSubsequenceI {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ?-1 : Math.max(a.length(), b.length());
    }
}
