package pickone;
/**
 * Revisit on 9/13/2017, One thing (like a trap) is:
 * 
 * You have to consider the situation of comparing 1.1.0 and 1.1, where the
 * lengths are not completely equal but they're actually the same
 * 
 * 
 * Besides, add a new solution without splitting
 * 
 * 
 * https://leetcode.com/problems/compare-version-numbers/
 * @author caos1
 * Key Points:
 *     1. Note : 1 is equal with 1.0
 *     2. Split is actually kind of lazy, may need to parse chars in some solutions
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");
        int length = Integer.max(parts1.length, parts2.length);
        for (int i = 0; i < length; i ++) {
            int ver1 = parts1.length <= i ? 0 : Integer.valueOf(parts1[i]);
            int ver2 = parts2.length <= i ? 0 : Integer.valueOf(parts2[i]);
            if (ver1 < ver2) {
                return -1;
            } else if (ver1 > ver2) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * New solution without split
     * @param version1
     * @param version2
     * @return
     */
    public int another(String version1, String version2) {
        int i = 0, j = 0;
        while (i < version1.length() || j < version2.length()) {
            int v1 = 0;
            while(i < version1.length() && version1.charAt(i) != '.') {
                v1 = v1 * 10 + version1.charAt(i ++) - '0';
            }
            i ++;
            int v2 = 0;
            while(j < version2.length() && version2.charAt(j) != '.') {
                v2 = v2 * 10 + version2.charAt(j ++) - '0';
            }
            j ++;
            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
        }
        return 0;
    }
}
