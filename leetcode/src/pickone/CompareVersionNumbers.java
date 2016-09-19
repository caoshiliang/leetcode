package pickone;
/**
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
}
